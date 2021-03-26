package Utilities;

import Deck.Cards;
import Deck.Types;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Flush {

    public boolean checkForFlush(Player player, ArrayList<Cards> community){
        ArrayList<Types> flush = new ArrayList<Types>();
        for (Cards cards : community){
            flush.add(cards.getType());
        }
        flush.add(player.getHand().get(0).getType());
        flush.add(player.getHand().get(1).getType());
        int diamondsOccurrences = checkTypeOccurrences(Types.DIAMOND, flush);
        int spadesOccurrences = checkTypeOccurrences(Types.SPADES, flush);
        int clubsOccurrences = checkTypeOccurrences(Types.CLUBS, flush);
        int heartsOccurrences = checkTypeOccurrences(Types.HEARTS, flush);
        return diamondsOccurrences >= 5 || spadesOccurrences >= 5 || clubsOccurrences >= 5 || heartsOccurrences >= 5;
    }

    public int checkTypeOccurrences(Types type, ArrayList<Types> flush){
        return Collections.frequency(flush, type);
    }
}
