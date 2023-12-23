package com.l09gr01.badice;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.state.State;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {

    private final InputHandler gui;
    private State state;
    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new InputHandler(39,41);
        this.state = new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();
        System.exit(0);
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
                    System.err.println("Game interrupted: " + e.getMessage());
                }
            }
        }
        gui.close();
    }
    public void setState(State state) {
        this.state = state;
    }

    public InputHandler getGui() {
        return gui;
    }

    public State getState(){ return this.state;}

}
