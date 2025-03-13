import java.util.List;

public class DCClient extends Client {

  private List <Player> players ;

  private List cards;

  private Player turn;

  private int pile;

  private boolean joined;

  
  public void DCClient(String ip, int port) {
  }

  public void processMessage(String message) {
  }

  public void addPlayer(Player player) {
  }

  public void removePlayer(Player player) {
  }

  public void setCards(List cards) {
  }

  public void drawCard(Card card) {
  }

  public void playCard(Card card) {
  }

  public List getPlayers() {
  return null;
  }

  public List getCards() {
  return null;
  }

  public Player getTurn() {
  return null;
  }

  public int getPile() {
  return 0;
  }

}