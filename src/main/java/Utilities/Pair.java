package Utilities;

import Deck.Cards;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Pair {

    public boolean checkForPair(Player player, ArrayList<Cards> community){
        ArrayList<Cards> copy = new ArrayList<Cards>();
        ArrayList<Integer> compare = new ArrayList<Integer>();
        copy.addAll(community);
        copy.addAll(player.getHand());
        for (Cards cards : copy){
            compare.add(cards.getNumber());
        }
        for (Integer number : compare){
            if (Collections.frequency(compare, number) == 2){
                player.setPair(number);
                return true;
            }
        }
        return false;
    }

}
