package Deck;

public class Cards {

    private Ranks rank;
    private int number;
    private Types type;
    private Emblems emblem;

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Ranks getRank() {
        return rank;
    }

    public void setRank(Ranks rank) {
        this.rank = rank;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Emblems getEmblem() { return emblem; }

    public void setEmblem(Emblems emblem) { this.emblem = emblem; }



}
