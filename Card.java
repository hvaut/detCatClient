
public enum Card {

    CAT("CAT"),
    SKIP("SKIP"),
    DEFUSE("DEFUSE"),
    DET_CAT("DET");

    /**
     * Gibt eine Karte zurück, wenn dessen Id mit dem Parameter übereinstimmt
     *
     * @param string die Id der gesuchten Karte
     * @return gibt die gesuchte Karte zurück
     */
    public static Card getCard(String string) {
        for (Card card : values()) {
            if (card.getId().equalsIgnoreCase(string))
                return card;
        }
        return null;
    }

    private String id;
    private int count;

    Card(String pId) {
        id = pId;
        count = 0;
    }

    /**
     * Setzt die Anzahl einer Karte
     *
     * @param pCount die Anzahl der Karte
     */
    public void setCount(int pCount) {
        count = pCount;
    }

    /**
     * Gibt die Id der Karte zurück
     *
     * @return die Id der Karte
     */
    public String getId() {
        return id;
    }

    /**
     * Gibt die Anzahl der Karte zurück
     *
     * @return die Anzahl der Karte
     */
    public int getCount() {
        return count;
    }

}
