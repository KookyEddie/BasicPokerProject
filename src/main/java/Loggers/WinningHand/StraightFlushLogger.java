package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;
import Utilities.Flush;
import Utilities.Straight;

import java.util.ArrayList;

public class StraightFlushLogger extends WinningHandLogger {

    private final Straight StraightUtilities = new Straight();
    private final Flush FlushtUtilities = new Flush();

    public StraightFlushLogger(int ranking) {
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        if (StraightUtilities.checkForStraight(player, community)){
            if (FlushtUtilities.checkForFlush(player, community)){
                return this.ranking;
            }
        }
        return 0;
    }
}
