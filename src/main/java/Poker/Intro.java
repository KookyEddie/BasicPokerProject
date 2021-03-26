package Poker;

import Loggers.GameTypeLoggers.FermeLogger;
import Loggers.GameTypeLoggers.RoyalLogger;
import Loggers.GameTypeLoggers.GameLogger;
import Loggers.GameTypeLoggers.OhamaLogger;
import Loggers.GameTypeLoggers.TexasLogger;
import Poker.GameModes.GameType;

import java.util.Scanner;

public class Intro {

    Scanner clavier = new Scanner(System.in);

    public Intro(){
        showAvailableGame();
        int choice = clavier.nextInt();
        choseGame(choice);
    }

    public void showAvailableGame(){
        int i = 1;
        for (GameType type : GameType.values()){
            System.out.print(type + " | ");
            System.out.println(i);
            i++;
        }
        System.out.println();
        System.out.print("Please enter the right number for the game of your choice : ");
    }

    public void choseGame(int game){
        GameLogger TexasLogger = new TexasLogger(GameLogger.TEXAS);
        GameLogger OhamaLogger = new OhamaLogger(GameLogger.OHAMA);
        GameLogger FermeLogger = new FermeLogger(GameLogger.FERME);
        GameLogger RoyalLogger = new RoyalLogger(GameLogger.ROYAL);

        TexasLogger.setNextLogger(OhamaLogger);
        OhamaLogger.setNextLogger(FermeLogger);
        FermeLogger.setNextLogger(RoyalLogger);

        TexasLogger.logMessage(game);
    }

}
