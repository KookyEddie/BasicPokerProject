package Loggers.WinningHand;

import Deck.Cards;
import Players.Player;

import java.util.ArrayList;

public abstract class WinningHandLogger {
    public final static int ROYAL_FLUSH = 1;
    public final static int STRAIGHT_FLUSH = 2;
    public final static int FOUR_OF_A_KIND = 3;
    public final static int FULL_HOUSE = 4;
    public final static int FLUSH = 5;
    public final static int STRAIGHT = 6;
    public final static int THREE_OF_A_KIND = 7;
    public final static int TWO_PAIR = 8;
    public final static int PAIR = 9;
    public final static int HIGH_CARD = 10;

    protected int ranking;
    protected WinningHandLogger nextLogger;

    abstract protected int verify(Player player, ArrayList<Cards> community);

    public void setNextLogger(WinningHandLogger nextLogger) { this.nextLogger = nextLogger; }

    public void checkWinning(Player player, ArrayList<Cards> community){
        int result = verify(player, community);
        if (result == this.ranking){
            checkHighestCard(player);
            player.setRank(result);
        } else {
            nextLogger.checkWinning(player, community);
        }
    }

    public void checkHighestCard(Player player){
        int card1 = player.getHand().get(0).getNumber();
        int card2 = player.getHand().get(1).getNumber();
        if (card1 > card2 && card1!= player.getPair()){
            player.setHighestCard(card1);
        } else {
            player.setHighestCard(card2);
        }
    }
}
