package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;
import Utilities.Flush;

import java.util.ArrayList;

public class FlushLogger extends WinningHandLogger{

    private final Flush utilities = new Flush();

    public FlushLogger(int ranking) {
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        if (utilities.checkForFlush(player, community)){
            return ranking;
        }
        return 0;
    }

}
