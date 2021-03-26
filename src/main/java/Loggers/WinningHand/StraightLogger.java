package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;
import Utilities.Straight;

import java.util.ArrayList;

public class StraightLogger extends WinningHandLogger {

    private final Straight StraightUtilities = new Straight();

    public StraightLogger(int ranking){
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        if (StraightUtilities.checkForStraight(player, community)){
            return this.ranking;
        }
        return 0;
    }
}
