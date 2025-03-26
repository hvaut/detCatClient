import java.util.List;

public class DCClient extends Client {
    
    private int pile;
    private boolean joined;
    public DCClient(String ip, int port) {
        super(ip, port);
        
    }

    public void processMessage(String message) {
    }
    
    public void drawCard() {
    }

    public void playCard() {
    }

    public List getPlayers() {
        return null;
    }

    public List getCards() {
        return null;
    }

    public int getTurn() {
        return 0;
    }

    public int getPile() { 
        return pile;
    }

}