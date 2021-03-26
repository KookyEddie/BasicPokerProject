package Utilities;

import Deck.Cards;
import Players.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Straight {

    public boolean checkForStraight(Player player, ArrayList<Cards> community){
        int[] chiffre = new int[7];
        ArrayList<Cards> copy = new ArrayList<Cards>();
        copy.addAll(community);
        copy.addAll(player.getHand());
        int i = 0;
        for (Cards cards : copy){
            chiffre[i] = cards.getNumber();
            i++;
        }
        Arrays.sort(chiffre);
        for (int a = 0; a < 3; a++){
            if (chiffre[chiffre.length - 1] == chiffre[chiffre.length - 2] + 1 &&
                    chiffre[chiffre.length - 2] == chiffre[chiffre.length - 3] + 1 &&
                        chiffre[chiffre.length - 3] == chiffre[chiffre.length - 4] + 1 &&
                            chiffre[chiffre.length - 4] == chiffre[chiffre.length - 5] + 1){
                return true;
            }
            chiffre = Arrays.copyOf(chiffre, chiffre.length - 1);
        }
        return false;
    }
}
