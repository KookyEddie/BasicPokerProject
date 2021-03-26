package Loggers.GameTypeLoggers;

public abstract class GameLogger {
    public final static int TEXAS = 1;
    public final static int OHAMA = 2;
    public final static int FERME = 3;
    public final static int ROYAL = 4;

    protected int game;
    protected GameLogger nextLogger;

    abstract protected void write();

    public void setNextLogger(GameLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level) {
        if (this.game == level) {
            write();
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level);
        }
    }


}
