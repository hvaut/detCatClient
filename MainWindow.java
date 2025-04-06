import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Lumin007
 */
public class MainWindow extends JFrame {

    private LoginPanel loginPanel;
    private GamePanel gamePanel;

    private DCClient client;

    public MainWindow(DCClient pClient) {
        client = pClient;

        initComponents();

        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        loginPanel = new LoginPanel(this);
        gamePanel = new GamePanel(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new CardLayout());
        getContentPane().add(loginPanel, "login");
        getContentPane().add(gamePanel, "game");

        pack();
    }

    /**
     * Setzt das aktuelle Fenster auf Login
     */
    public void switchToLogin() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "login");
    }

    /**
     * Setzt das aktuelle Fenster auf Game
     */
    public void switchToGame() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "game");
    }

    /**
     * Erstellt ein Fenster mit einer Fehlermeldung
     *
     * @param pError die Fehlermeldung
     */
    public void popupError(String pError) {
        PopupWindow popupWindow = createPopup();
        popupWindow.switchPanelToError();
        popupWindow.getErrorPopup().setErrorMessage(pError);
    }

    /**
     * Erstellt ein Fenster mit einer Todesnachricht
     */
    public void popupDeath() {
        PopupWindow popupWindow = createPopup();
        popupWindow.switchPanelToDeath();
    }

    /**
     * Erstellt ein Fenster zum Entschärfen einer Bombe
     */
    public void popupDefuse() {
        PopupWindow popupWindow = createPopup();
        popupWindow.switchPanelToDefuse();
    }

    private PopupWindow createPopup() {
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setVisible(true);
        return popupWindow;
    }

    /**
     * Gibt das Login Fenster zurück
     *
     * @return das Login Fenster
     */
    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    /**
     * Gibt das Game Fenster zurück
     *
     * @return das Game Fenster
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * Gibt den Client zurück
     *
     * @return der Client
     */
    public DCClient getClient() {
        return client;
    }

}