package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;
import Utilities.Pair;

import java.util.ArrayList;

public class PairLogger extends WinningHandLogger {

    private final Pair PairUtilities = new Pair();

    public PairLogger(int ranking) {
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        if (PairUtilities.checkForPair(player, community)){
            return this.ranking;
        }
        return 0;
    }
}
