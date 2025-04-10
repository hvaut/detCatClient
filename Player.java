public class Player {

    private String name;
    private boolean alive;

    public Player(String pName) {
        name = pName;
        alive = true;
    }

    /**
     * Setzt, ob der Spieler am Leben ist
     *
     * @param pAlive true, wenn der Spieler lebt und ansonsten false
     */
    public void setAlive(boolean pAlive) {
        alive = pAlive;
    }

    /**
     * Gibt den Namen des Spielers zurück
     *
     * @return der Name des Spielers
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt zurück, ob der Spieler am Leben ist
     *
     * @return ob die Bedingung erfüllt ist
     */
    public boolean isAlive() {
        return alive;
    }

}
