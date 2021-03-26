package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;

public class FullHouseLogger extends WinningHandLogger{

    public FullHouseLogger(int ranking) {
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        ArrayList<Cards> copy = new ArrayList<Cards>();
        ArrayList<Integer> compare = new ArrayList<Integer>();
        copy.addAll(community);
        copy.addAll(player.getHand());
        int occurrence = 0;
        for (Cards cards : copy){
            compare.add(cards.getNumber());
        }
        for (Integer number : compare){
            occurrence = Collections.frequency(compare, number);
            if (occurrence == 2){
                for (Integer number2 : compare){
                    occurrence = Collections.frequency(compare, number2);
                    if (occurrence == 3){
                        return this.ranking;
                    }
                }
            }
        }
        return 0;
    }
}
