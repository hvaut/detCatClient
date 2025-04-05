public class Player {

    private String name;
    private boolean alive;

    public Player(String pName) {
        name = pName;
        alive = true;
    }

    public void setAlive(boolean pAlive) {
        alive = pAlive;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

}
