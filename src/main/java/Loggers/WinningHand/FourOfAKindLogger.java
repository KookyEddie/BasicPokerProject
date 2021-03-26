package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;

public class FourOfAKindLogger extends WinningHandLogger {

    public FourOfAKindLogger(int ranking) {
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        ArrayList<Cards> copy = new ArrayList<Cards>();
        ArrayList<Integer> compare = new ArrayList<Integer>();
        copy.addAll(community);
        copy.addAll(player.getHand());
        int occurences = 0;
        for (Cards cards : copy){
            compare.add(cards.getNumber());
        }
        for (Integer carte : compare){
            occurences = Collections.frequency(compare, carte);
            if (occurences == 4){
                return this.ranking;
            }
        }
        return 0;
    }
}
