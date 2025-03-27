

public class DCClient extends Client {

    private int pile;
    private boolean joined;
    private String turn;
    private List<String> players;


    public DCClient(String ip, int port) {
        super(ip, port);
        players = new List<String>();
        //List<String> players = new List();
    }

    public void processMessage(String message) {
        //String[] data = message.split(" ");
        //array isn´t empty
        //if (data.length < 1) {
        //    send(ip, port, "-ERR Wrong command");
        //    return;
        //}

        //if (data[0] == "+OK"){
        //    if
        //} else if (data[0] == "-ERR") {

        //} else {

        //}

    }

    public void drawCard() {

    }

    public void playCard() {

    }

    public List<String> getPlayers() {
        //toFirst();
        //String erg = "";
        //while(hasAccess()){
        //    erg = erg + getContent().getName();
        //    next();
        //}
        //return erg;

        return null;
    }

    public List<String> getCards() {
        return players;
    }

    public int getTurn() {
        return 0;
    }

    public int getPile() { 
        return pile;
    }

}