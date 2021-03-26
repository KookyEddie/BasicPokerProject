package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;
import Utilities.Flush;
import Utilities.Straight;

import java.util.ArrayList;
import java.util.Arrays;

public class RoyalFlushLogger extends WinningHandLogger {

    private final Flush FlushUtilities = new Flush();
    private final Straight StraightUtilities = new Straight();

    public RoyalFlushLogger(int ranking) {
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        if (FlushUtilities.checkForFlush(player, community)){
            if (checkForHighStraight(player, community)){
                return ranking;
            }
        }
        return 0;
    }


    private boolean checkForHighStraight(Player player, ArrayList<Cards> community){
        ArrayList<Cards> copy = new ArrayList<Cards>(community);
        copy.add(player.getHand().get(0));
        copy.add(player.getHand().get(1));
        copy.addAll(community);
        if (StraightUtilities.checkForStraight(player, community)){
            int[] chiffre;
            int index  = 6;
            chiffre = sortArray(copy);
            for (int i = 0; i < 3; i++){
                if (chiffre[index] == 1 && chiffre[index - 1] == 13){
                    return true;
                }
                index--;
            }
        }
        return false;
    }

    private int[] sortArray(ArrayList<Cards> copyOfcopy){
        int[] chiffre = new int[7];
        int i = 0;
        for (Cards cards : copyOfcopy){
            chiffre[i] = cards.getNumber();
            i++;
        }
        Arrays.sort(chiffre);
        return chiffre;
    }
}
