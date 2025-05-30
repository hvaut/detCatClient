import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Klasse Client
 * </p>
 * <p>
 * Objekte von Unterklassen der abstrakten Klasse Client ermoeglichen
 * Netzwerkverbindungen zu einem Server mittels TCP/IP-Protokoll. Nach
 * Verbindungsaufbau koennen Zeichenketten (Strings) zum Server gesendet und von
 * diesem empfangen werden, wobei der Nachrichtenempfang nebenlaeufig geschieht.
 * Zur Vereinfachung finden Nachrichtenversand und -empfang zeilenweise statt,
 * d. h., beim Senden einer Zeichenkette wird ein Zeilentrenner ergaenzt und beim
 * Empfang wird dieser entfernt. Jede empfangene Nachricht wird einer
 * Ereignisbehandlungsmethode uebergeben, die in Unterklassen implementiert werden
 * muss. Es findet nur eine rudimentaere Fehlerbehandlung statt, so dass z.B.
 * Verbindungsabbrueche nicht zu einem Programmabbruch fuehren. Eine einmal
 * unterbrochene oder getrennte Verbindung kann nicht reaktiviert werden.
 * </p>
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule (Bearbeitet)
 * @version 13.04.2025
 */

public abstract class Client {

    private MessageHandler messageHandler;

    public Client(String pServerIP, int pServerPort) {
        messageHandler = new MessageHandler(pServerIP, pServerPort);
    }

    public void send(String pMessage) {
        messageHandler.send(pMessage);
    }

    public void close() {
        messageHandler.close();
    }

    public boolean isConnected() {
        return messageHandler.active;
    }

    public abstract void processMessage(String pMessage);

    private class MessageHandler extends Thread {

        private SocketWrapper socketWrapper;
        private boolean active;

        private MessageHandler(String pServerIP, int pServerPort) {
            socketWrapper = new SocketWrapper(pServerIP, pServerPort);
            start();
            if (socketWrapper.socket != null)
                active = true;
        }

        public void run() {
            String message;
            while (active) {
                message = socketWrapper.receive();
                if (message != null) processMessage(message);
                else close();
            }
        }

        private void send(String pMessage) {
            if (active) socketWrapper.send(pMessage);
        }

        private void close() {
            if (active) {
                active = false;
                socketWrapper.close();
            }
        }

        private class SocketWrapper {

            private Socket socket;
            private BufferedReader fromServer;
            private PrintWriter toServer;

            public SocketWrapper(String pServerIP, int pServerPort) {
                try {
                    socket = new Socket(pServerIP, pServerPort);
                    toServer = new PrintWriter(socket.getOutputStream(), true);
                    fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                } catch (IOException e) {
                    socket = null;
                    toServer = null;
                    fromServer = null;
                }
            }

            public String receive() {
                if (fromServer != null)
                    try {
                        return fromServer.readLine();
                    } catch (IOException e) {
                    }
                return (null);
            }

            public void send(String pMessage) {
                if (toServer != null) {
                    toServer.println(pMessage);
                }
            }

            public void close() {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        /*
                         * Falls eine Verbindung getrennt werden soll, deren Endpunkt
                         * nicht mehr existiert bzw. ihrerseits bereits beendet worden ist,
                         * geschieht nichts.
                         */
                    }
                }
            }

        }

    }

}

