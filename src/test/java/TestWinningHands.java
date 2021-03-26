import Deck.Cards;
import Deck.Types;
import Loggers.WinningHand.*;
import Players.Player;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestWinningHands {

    @Test
    public void testFlush(){
        FlushLogger s = new FlushLogger(5);
        ArrayList<Cards> community = new ArrayList<Cards>();
        Player player = new Player();
        Cards card = new Cards();
        card.setType(Types.SPADES);
        Cards card2 = new Cards();
        card.setType(Types.CLUBS);
        community.add(card);
        community.add(card);
        community.add(card);
        community.add(card2);
        community.add(card2);
        player.setHand(card);
        player.setHand(card);
        Assert.assertEquals(s.verify(player, community), 5);
    }

    @Test
    public void testRoyalFlush(){
        RoyalFlushLogger s = new RoyalFlushLogger(1);
        ArrayList<Cards> community = new ArrayList<Cards>();
        Player player = new Player();
        Cards card = new Cards();
        card.setType(Types.SPADES);
        card.setNumber(1);
        Cards card3 = new Cards();
        card3.setType(Types.SPADES);
        card3.setNumber(13);
        Cards card4 = new Cards();
        card4.setType(Types.SPADES);
        card4.setNumber(12);
        Cards card5 = new Cards();
        card5.setType(Types.SPADES);
        card5.setNumber(11);
        Cards card6 = new Cards();
        card6.setType(Types.SPADES);
        card6.setNumber(10);
        Cards card7 = new Cards();
        card7.setType(Types.CLUBS);
        card7.setNumber(2);
        Cards card8 = new Cards();
        card8.setType(Types.CLUBS);
        card8.setNumber(3);
        player.setHand(card);
        player.setHand(card3);
        community.add(card4);
        community.add(card5);
        community.add(card6);
        community.add(card7);
        community.add(card8);
        Assert.assertEquals(s.verify(player, community), 1);
    }

    @Test
    public void testStraightFlush(){
        StraightFlushLogger s = new StraightFlushLogger(2);
        ArrayList<Cards> community = new ArrayList<Cards>();
        Player player = new Player();
        Cards card = new Cards();
        Cards card2 = new Cards();
        Cards card3 = new Cards();
        Cards card4 = new Cards();
        Cards card5 = new Cards();
        Cards card6 = new Cards();
        Cards card7 = new Cards();
        card.setNumber(4);
        card.setType(Types.SPADES);
        card2.setNumber(6);
        card2.setType(Types.SPADES);
        card3.setNumber(7);
        card3.setType(Types.SPADES);
        card4.setNumber(13);
        card5.setNumber(1);
        card6.setNumber(3);
        card6.setType(Types.SPADES);
        card7.setNumber(5);
        card7.setType(Types.SPADES);
        player.setHand(card6);
        player.setHand(card7);
        community.add(card);
        community.add(card2);
        community.add(card3);
        community.add(card4);
        community.add(card5);
        Assert.assertEquals(s.verify(player, community), 2);
    }

    @Test
    public void testFourOfAKind(){
        FourOfAKindLogger s = new FourOfAKindLogger(3);
        ArrayList<Cards> community = new ArrayList<Cards>();
        Player player = new Player();
        Cards card = new Cards();
        Cards card2 = new Cards();
        Cards card3 = new Cards();
        Cards card4 = new Cards();
        Cards card5 = new Cards();
        Cards card6 = new Cards();
        Cards card7 = new Cards();
        card.setNumber(4);
        card2.setNumber(1);
        card3.setNumber(1);
        card4.setNumber(1);
        card5.setNumber(2);
        card6.setNumber(1);
        card7.setNumber(6);
        player.setHand(card2);
        player.setHand(card);
        community.add(card3);
        community.add(card4);
        community.add(card5);
        community.add(card6);
        community.add(card7);
        Assert.assertEquals(s.verify(player, community), 3);
    }

    @Test
    public void testFullHouse(){
        FullHouseLogger s = new FullHouseLogger(4);
        ArrayList<Cards> community = new ArrayList<Cards>();
        Player player = new Player();
        Cards card = new Cards();
        Cards card2 = new Cards();
        Cards card3 = new Cards();
        Cards card4 = new Cards();
        Cards card5 = new Cards();
        Cards card6 = new Cards();
        Cards card7 = new Cards();
        card.setNumber(2);
        card2.setNumber(4);
        card3.setNumber(2);
        card4.setNumber(1);
        card5.setNumber(10);
        card6.setNumber(4);
        card7.setNumber(4);
        player.setHand(card2);
        player.setHand(card);
        community.add(card3);
        community.add(card4);
        community.add(card5);
        community.add(card6);
        community.add(card7);
        Assert.assertEquals(s.verify(player, community), 4);
    }

    @Test
    public void Straight(){
        StraightLogger s = new StraightLogger(6);
        ArrayList<Cards> community = new ArrayList<Cards>();
        Player player = new Player();
        Cards card = new Cards();
        Cards card2 = new Cards();
        Cards card3 = new Cards();
        Cards card4 = new Cards();
        Cards card5 = new Cards();
        Cards card6 = new Cards();
        Cards card7 = new Cards();
        card.setNumber(1);
        card2.setNumber(4);
        card3.setNumber(3);
        card4.setNumber(5);
        card5.setNumber(2);
        card6.setNumber(11);
        card7.setNumber(1);
        player.setHand(card);
        player.setHand(card2);
        community.add(card3);
        community.add(card4);
        community.add(card5);
        community.add(card6);
        community.add(card7);
        Assert.assertEquals(s.verify(player, community), 6);
    }

    @Test
    public void ThreeOfAKind(){
        ThreeOfAKindLogger s = new ThreeOfAKindLogger(7);
        ArrayList<Cards> community = new ArrayList<Cards>();
        Player player = new Player();
        Cards card = new Cards();
        Cards card2 = new Cards();
        Cards card3 = new Cards();
        card.setNumber(1);
        card2.setNumber(4);
        card3.setNumber(10);
        player.setHand(card2);
        player.setHand(card3);
        community.add(card);
        community.add(card);
        community.add(card);
        community.add(card2);
        community.add(card3);
        Assert.assertEquals(s.verify(player, community), 7);
    }

    @Test
    public void TwoPair(){
        TwoPairLogger s = new TwoPairLogger(8);
        ArrayList<Cards> community = new ArrayList<Cards>();
        Player player = new Player();
        Cards card = new Cards();
        Cards card2 = new Cards();
        Cards card3 = new Cards();
        Cards card4 = new Cards();
        Cards card5 = new Cards();
        Cards card6 = new Cards();
        Cards card7 = new Cards();
        card.setNumber(1);
        card2.setNumber(1);
        card3.setNumber(2);
        card4.setNumber(3);
        card5.setNumber(4);
        card6.setNumber(5);
        card7.setNumber(2);
        player.setHand(card);
        player.setHand(card2);
        community.add(card3);
        community.add(card4);
        community.add(card5);
        community.add(card6);
        community.add(card7);
        Assert.assertEquals(s.verify(player, community), 8);
    }

    @Test
    public void Pair(){
        PairLogger s = new PairLogger(9);
        ArrayList<Cards> community = new ArrayList<Cards>();
        Player player = new Player();
        Cards card = new Cards();
        Cards card2 = new Cards();
        Cards card3 = new Cards();
        Cards card4 = new Cards();
        Cards card5 = new Cards();
        Cards card6 = new Cards();
        Cards card7 = new Cards();
        card.setNumber(1);
        card2.setNumber(1);
        card3.setNumber(2);
        card4.setNumber(3);
        card5.setNumber(4);
        card6.setNumber(5);
        card7.setNumber(10);
        player.setHand(card);
        player.setHand(card2);
        community.add(card3);
        community.add(card4);
        community.add(card5);
        community.add(card6);
        community.add(card7);
        Assert.assertEquals(s.verify(player, community), 9);
    }

}
