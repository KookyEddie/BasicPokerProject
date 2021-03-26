package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;

import java.util.ArrayList;

public class HighCardLogger extends WinningHandLogger{

    public HighCardLogger(int ranking) {
        this.ranking = ranking;
    }

    public int verify(Player player, ArrayList<Cards> community) {
        return this.ranking;
    }
}
