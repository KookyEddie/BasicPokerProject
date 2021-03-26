package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;
import Utilities.ThreeOfAKind;

import java.util.ArrayList;

public class ThreeOfAKindLogger extends WinningHandLogger {

    private final ThreeOfAKind TOAKUtilities = new ThreeOfAKind();

    public ThreeOfAKindLogger(int ranking){
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        if (TOAKUtilities.checkForThreeOfAKind(player, community)){
            return this.ranking;
        }
        return 0;
    }
}
