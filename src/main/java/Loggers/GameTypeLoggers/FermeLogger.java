package Loggers.GameTypeLoggers;

public class FermeLogger extends GameLogger {

    public FermeLogger(int game){
        this.game = game;
    }

    protected void write() {
        System.out.println("Feature not yet implemented. Ferme game coming soon.");
    }
}
