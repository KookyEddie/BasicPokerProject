package Deck;

import java.util.ArrayList;

public class Dealer {

    private final ArrayList<Cards> deck;
    private int emblem;

    public Dealer(){
        deck = new ArrayList<Cards>();
        emblem = 0;
        createDeck();
    }

    public void createDeck(){
       for (Types type : Types.values()){
           int number = 1;
           for (Ranks rank : Ranks.values()){
               Cards card = new Cards();
               card.setNumber(number);
               card.setType(type);
               card.setRank(rank);
               card.setEmblem(Emblems.values()[emblem]);
               deck.add(card);
               number++;
           }
           emblem++;
       }
    }

    public ArrayList<Cards> getDeck() {
        return deck;
    }

}
