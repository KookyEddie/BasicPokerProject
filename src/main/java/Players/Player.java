package Players;

import Deck.Cards;

import java.util.ArrayList;

public class Player {

    private ArrayList<Cards> hand;
    private int rank;
    private int highestCard;
    private int pair;

    public Player(){
        hand = new ArrayList<Cards>();
    }

    public ArrayList<Cards> getHand() {
        return hand;
    }

    public void setHand(Cards card) {
        hand.add(card);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getHighestCard() {
        return highestCard;
    }

    public int getPair() { return pair; }

    public void setPair(Integer number) { pair = number; }

    public void setHighestCard(int highestCard) {
        this.highestCard = highestCard;
    }
}
