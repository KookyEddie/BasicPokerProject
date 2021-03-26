package Poker.GameModes;

import Deck.Cards;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class Game {

    public int numberPlayer;
    public int numberPlayerMax;
    public int numberPlayerMin;
    public int numberCardPerPlayer;

    public ArrayList<Player> players;
    public ArrayList<Cards> community = new ArrayList<Cards>();
    private ArrayList<Cards> deck = new ArrayList<Cards>();

    public void createDeck() {
        deck = new Deck.Dealer().getDeck();
    }

    public void shuffleCards(){
        Collections.shuffle(deck);
    }

    public abstract void startGame(Scanner scanner);

    public abstract int askNumberPlayer(Scanner scanner);

    public abstract void generatePlayers();

    public abstract void distributeCardsToPlayers();

    public abstract void communityTable();

    public abstract int endgame(Scanner scanner);

    public abstract void checkWinningHand();

    public ArrayList<Cards> getDeck() {
        return deck;
    }

}
