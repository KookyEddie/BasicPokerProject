package Loggers.GameTypeLoggers;

public class OhamaLogger extends GameLogger {

    public OhamaLogger(int game){
        this.game = game;
    }

    protected void write() {
        System.out.println("Feature not yet implemented. Ohama game coming soon.");
    }
}
