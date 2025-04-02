
public class DCClient extends Client {
    private int pile;
    private boolean joined;

    private List<String> cards;

    private String turn;
    private List<String> players;
    private MainGui gui;


    public DCClient(String ip, int port) {
        super(ip, port);

        cards = new List<String>();

        players = new List<String>();
        //List<String> players = new List();     
        //List<String> players = new List();
        gui = new MainGui(this);
    }

    /**
     * Methode processMessage
     * 
     * @return Der Rückgabewert
     * 
     * Aufgabe: Alle Fälle implementieren
     */
    public void processMessage(String pMessage) {
        String[] data = pMessage.split(" ");
        // make sure the array is not empty
        if (data.length < 1) {
            send("-ERR Wrong command");
            return;
        }

        // handle every command
        if (data[0].equalsIgnoreCase("+OK")){
            if (data [1].equalsIgnoreCase("Logged") && data.length == 3) {
                if (data[2].equalsIgnoreCase("in")) {
                    //login Bestätigung -> GUI
                } else if (data[2].equalsIgnoreCase("out")) {
                    //logout Bestätigung -> GUI
                } else {
                    send("-ERR Wrong command");
                    return;
                }
            } else if (data[1].equalsIgnoreCase("Game") && data.length == 3) {
                if (data[2].equalsIgnoreCase("hosted")) {
                    // Game hosted
                } else if (data[2].equalsIgnoreCase("starts")) {
                    // Game starts
                    
                    //fill pile
                    pile = 80;
                    players.toFirst();
                    //add 1 defuse card + 7 random
                    int playerCount = 0;
                    while(players.hasAccess()){
                        playerCount++;
                        pile = pile -8;
                        players.next();
                    }
                    
                    for(int i = 0; i < playerCount - 1; i++){
                        pile++;
                    }
                } else {
                    send("-ERR Wrong command");
                    return;
                }
            } else if (data[1].equalsIgnoreCase("Joined") && data[2].equalsIgnoreCase("the") && data[3].equalsIgnoreCase("game") && data.length == 4) {
                // Joined Game
            } else if (data[1].equalsIgnoreCase("Left") && data[2].equalsIgnoreCase("the") && data[3].equalsIgnoreCase("game") && data.length == 4) {
                // Left Game
            } else if (data[1].equalsIgnoreCase("Took") && data[2].equalsIgnoreCase("a") && data[3].equalsIgnoreCase("card") && data.length == 4) {
                // Took Card
            } else if (data[1].equalsIgnoreCase("Defused") && data[2].equalsIgnoreCase("the") && data[3].equalsIgnoreCase("bomb") && data.length == 4) {
                // Bomb defused
            } else {
                send("-ERR Wrong command");
                return;
            }
        } else if (data[0].equalsIgnoreCase("-ERR")) {
            gui.error(pMessage);
        } else if (data[0].equalsIgnoreCase("BOMB") && data.length == 2) {
            // Player received a bomb
        } else if (data[0].equalsIgnoreCase("PLACE") && data.length == 3) {
            // Placing a card
        } else if (data[0].equalsIgnoreCase("TAKE") && data.length == 2) {
            // Taking a card
        } else if (data[0].equalsIgnoreCase("TURN") && data.length == 2) {
            // Shows currently active player
        } else if (data[0].equalsIgnoreCase("JOIN") && data.length == 2) {
            // A player joined
        } else if (data[0].equalsIgnoreCase("QUIT") && data.length == 2) {
            // A player left
        } else if (data[0].equalsIgnoreCase("DEATH") && data.length == 2) {
            // A player died
        } else if (data[0].equalsIgnoreCase("WIN") && data.length == 2) {
            // Winner is announced
        } else if (data[0].equalsIgnoreCase("CARD") && data.length == 2) {
            // Refreshing cards on hand
        } else if (data[0].equalsIgnoreCase("PLAYER") && data.length == 2) {
            // Refreshing players
        } else {
            send("-ERR Wrong command");
            return;
        }
    }

    public void drawCard() {

    }

    public void playCard() {
        
    }

    /**
     * Ist die im Client nötig?
     */
    public List<String> getPlayers() {
        return players;
    }
    
    /**
     * Methode addPlayer
     *
     * @param player Player hinzufügen
     * 
     * Aufgabe: Liste durchgehen und einen Spieler hinzufügen
     */
    public void addPlayer(String player) {
        players.append(player);
    }
    
    /**
     * Removes a player
     * 
     * @param player player to remove
     * 
     * Aufgabe: liste aller Spieler durchgehen und den ausgewählten Spieler aus der Liste entfernen
     */
    public void removePlayer(String player) {
        players.toFirst();
        while (players.hasAccess()){
            String name = players.getContent();
            if (name.equals(player)) break;
        }

        if (players.hasAccess()) players.remove();
    }

    /**
     * Methode getCards
     *
     * @return Der Rückgabewert
     * 
     * Aufgabe: die Liste ausgeben
     */
    public List<String> getCards() {
        return players;
    }

    /**
     * Ist die im Client nötig?
     */
    public String getTurn() {
        return turn;
    }

    /**
     * Ist die im Client nötig?
     */
    public int getPile() { 
        return pile;
    }

}
