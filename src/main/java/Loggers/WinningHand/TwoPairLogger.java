package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;

public class TwoPairLogger extends WinningHandLogger {

    public TwoPairLogger(int ranking){
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        ArrayList<Cards> copy = new ArrayList<Cards>();
        copy.addAll(community);
        copy.addAll(player.getHand());
        ArrayList<Integer> compare = new ArrayList<Integer>();
        int pair = 0;
        for (Cards cards : copy){
            compare.add(cards.getNumber());
        }
        for (int i = 0; i < 7; i++){
            if (Collections.frequency(compare, compare.get(i)) == 2){
                pair = compare.get(i);
                for (int b = i + 1; b < 7; b++){
                    if (Collections.frequency(compare, compare.get(b)) == 2 && compare.get(b) != pair){
                        return this.ranking;
                    }
                }
            }
        }
        return 0;
    }
}
