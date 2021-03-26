package Loggers.GameTypeLoggers;

import Poker.GameModes.Texas;

public class TexasLogger extends GameLogger {

    public TexasLogger(int game){
        this.game = game;
    }

    protected void write() {
        new Texas();
    }
}
