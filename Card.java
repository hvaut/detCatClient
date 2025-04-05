
public enum Card {

    CAT("CAT"),
    SKIP("SKIP"),
    DEFUSE("DEFUSE"),
    DET_CAT("DET");

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

    public void setCount(int pCount) {
        count = pCount;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

}
