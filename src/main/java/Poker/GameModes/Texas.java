package Poker.GameModes;

import Deck.Cards;
import Deck.WinningHand;
import Loggers.WinningHand.*;
import Players.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Texas extends Game {

    public Texas() {
        int restart = 0;
        do {
            community.clear();
            Scanner scanner = new Scanner(System.in);
            this.numberPlayerMax = 9;
            this.numberPlayerMin = 2;
            this.numberCardPerPlayer = 2;
            startGame(scanner);
            checkWinningHand();
            restart = endgame(scanner);
        } while (restart == 1);
    }

    public void startGame(Scanner scanner) {
        this.numberPlayer = askNumberPlayer(scanner);
        createDeck();
        shuffleCards();
        generatePlayers();
        distributeCardsToPlayers();
        communityTable();
    }

    public int askNumberPlayer(Scanner scanner) {
        int NbPlayers = 0;
        try {
            System.out.print("How many players should there be ? : ");
            NbPlayers = scanner.nextInt();
            if (NbPlayers < 2 || NbPlayers > 9){
                do {
                    System.out.printf("There must be atleast %d players and a maximum of %d players! \n", numberPlayerMin, numberPlayerMax);
                    System.out.print("How many players should there be ? : ");
                    NbPlayers = scanner.nextInt();
                } while (NbPlayers < 2 || NbPlayers > 9);
            }
        } catch (Exception e){
            System.out.println("Number of player must be of type integer! Default number of player will be 6.");
            NbPlayers = 6;
        }
        return NbPlayers;
    }

    public void generatePlayers() {
        this.players = new ArrayList<Player>();
        for (int i = 0; i < numberPlayer; i++){
            players.add(new Player());
        }
    }

    public void distributeCardsToPlayers() {
        for (int i = 0; i < numberCardPerPlayer; i++){
            for (Player player : players){
                player.setPair(0);
                player.setHand(getDeck().get(0));
                getDeck().remove(0);
            }
        }
    }

    public void communityTable(){
        getDeck().remove(0);
        for (int i = 0; i < 3; i++){
            community.add(getDeck().get(0));
            getDeck().remove(0);
        }
        for (int i = 0; i < 2; i++){
            getDeck().remove(0);
            community.add(getDeck().get(0));
            getDeck().remove(0);
        }
    }

    public int endgame(Scanner scanner) {
        int choice = 0;
        try {
            System.out.println("Would you like to play again");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            choice = scanner.nextInt();
            if (choice > 2 || choice < 1){
                do {
                    System.out.println("Enter a valid number");
                    choice = scanner.nextInt();
                } while (choice > 2 || choice < 1);
            }
            return choice;
        } catch (Exception e) {
            System.out.println("Enter the right value next time.");
            return 0;
        }
    }

    public void checkWinningHand() {
        WinningHandLogger RoyalFlushLogger = new RoyalFlushLogger(WinningHandLogger.ROYAL_FLUSH);
        WinningHandLogger StraightFlushLogger = new StraightFlushLogger(WinningHandLogger.STRAIGHT_FLUSH);
        WinningHandLogger FourOfAKindLogger = new FourOfAKindLogger(WinningHandLogger.FOUR_OF_A_KIND);
        WinningHandLogger FullHouseLogger = new FullHouseLogger(WinningHandLogger.FULL_HOUSE);
        WinningHandLogger FlushLogger = new FlushLogger(WinningHandLogger.FLUSH);
        WinningHandLogger StraightLogger = new StraightLogger(WinningHandLogger.STRAIGHT);
        WinningHandLogger ThreeOfAKindLogger = new ThreeOfAKindLogger(WinningHandLogger.THREE_OF_A_KIND);
        WinningHandLogger TwoPairLogger = new TwoPairLogger(WinningHandLogger.TWO_PAIR);
        WinningHandLogger PairLogger = new PairLogger(WinningHandLogger.PAIR);
        WinningHandLogger HighCardLogger = new HighCardLogger(WinningHandLogger.HIGH_CARD);

        RoyalFlushLogger.setNextLogger(StraightFlushLogger);
        StraightFlushLogger.setNextLogger(FourOfAKindLogger);
        FourOfAKindLogger.setNextLogger(FullHouseLogger);
        FullHouseLogger.setNextLogger(FlushLogger);
        FlushLogger.setNextLogger(StraightLogger);
        StraightLogger.setNextLogger(ThreeOfAKindLogger);
        ThreeOfAKindLogger.setNextLogger(TwoPairLogger);
        TwoPairLogger.setNextLogger(PairLogger);
        PairLogger.setNextLogger(HighCardLogger);

        for (Player players : players){
            RoyalFlushLogger.checkWinning(players, community);
        }

        showResults();

    }

    public void showResults(){
        showCommunity();

        for (Player players : players){
            System.out.println();
            System.out.print(players.getHand().get(0).getNumber() + " " + players.getHand().get(0).getEmblem() + " ");
            System.out.println(players.getHand().get(1).getNumber() + " " + players.getHand().get(1).getEmblem() + "   RANK : " + players.getRank() + "  HIGHEST CARD : " + players.getHighestCard());
        }

        Player winner = new Player();

        winner.setRank(100);

        for (Player players : players){
            if (players.getRank() < winner.getRank()){
                winner = players;
            }
            if (players.getRank() == 9 && winner.getRank() == 9){
                if (players.getPair() > winner.getPair()){
                    winner = players;
                } else if (players.getHighestCard() > winner.getHighestCard()){
                    winner = players;
                }
            }
            if (players.getRank() == winner.getRank() && players.getHighestCard() > winner.getHighestCard()){
                winner = players;
            }
        }

        System.out.println();
        System.out.print("Winner is the one with this hand : " + winner.getHand().get(0).getNumber() + " " + winner.getHand().get(0).getEmblem() + " ");
        System.out.print(winner.getHand().get(1).getNumber() + " " + winner.getHand().get(1).getEmblem() + "\n");
        System.out.println("Cette personne gagne avec : " + Arrays.toString(new WinningHand[]{WinningHand.values()[winner.getRank() - 1]}));
        System.out.println();
        System.out.println();
    }

    public void showCommunity(){
        System.out.println();
        for (Cards card : community){
            System.out.print(card.getEmblem() + " " + card.getNumber() + " ");
        }
        System.out.println();
    }

    public void cardLeft(){
        System.out.println(getDeck().size() + " cards left.");
    }
}
