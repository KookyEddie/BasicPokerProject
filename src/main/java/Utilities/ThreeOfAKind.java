package Utilities;

import Deck.Cards;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeOfAKind {

    public boolean checkForThreeOfAKind(Player player, ArrayList<Cards> community){
        ArrayList<Cards> copy = new ArrayList<Cards>();
        copy.addAll(community);
        copy.addAll(player.getHand());
        ArrayList<Integer> compare = new ArrayList<Integer>();
        for (Cards cards : copy){
            compare.add(cards.getNumber());
        }
        for (Integer number : compare){
            if (Collections.frequency(compare, number) == 3){
                return true;
            }
        }
        return false;
    }
}
