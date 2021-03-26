package Loggers.GameTypeLoggers;

public class RoyalLogger extends GameLogger {

    public RoyalLogger(int game){
        this.game = game;
    }

    protected void write() {
        System.out.println("Feature not yet implemented. Royal game coming soon.");
    }
}
