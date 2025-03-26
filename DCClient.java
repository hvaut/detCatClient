import java.util.List;

public class DCClient extends Client {
    
    private int pile;
    private boolean joined;
    

    public DCClient(String ip, int port) {
        super(ip, port);
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
        return 0;
    }

}