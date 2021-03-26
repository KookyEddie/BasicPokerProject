package Deck;

public enum Emblems {
    DIAMONDS("♦"),
    CLUBS("♣"),
    HEARTS("♥"),
    SPADES("♠");

    private String value;

    Emblems(String value) {
        this.value = value;
    }

    public String toString(){
        return this.value;
    }
}
