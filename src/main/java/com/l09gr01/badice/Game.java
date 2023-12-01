package com.l09gr01.badice;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.state.State;

import java.io.IOException;

public class Game {     // Game loop. Starting point

    private final InputHandler gui;
    private State state;

    public Game() throws IOException {
        this.gui = new InputHandler(40,40);
        this.state = new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.start();
    }

    public void start() throws IOException {
        int targetFPS = 30;
        long targetTimePerFrame = 1000 / targetFPS;
        while (this.state != null) {
            long startTime = System.currentTimeMillis();
            state.step(this,gui,startTime);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = targetTimePerFrame - elapsedTime;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        gui.close();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState(){ return this.state;}

}
