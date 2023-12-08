package com.l09gr01.badice;

<<<<<<< Updated upstream
public class Game {     // Game loop. Starting point

    private boolean isGameRunning = true;

    public static void main(String[] args) {
=======
import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.state.State;
import com.l09gr01.badice.utils.HiscoreEntry;
import com.l09gr01.badice.utils.LoadHiscores;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Game {

    private final InputHandler gui;
    private State state;
    private int levelUnlocks = 1;
    private static List<HiscoreEntry> hiscores = LoadHiscores.loadHiscores("data/hiscores.txt");

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new InputHandler(40,40);
        this.state = new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
>>>>>>> Stashed changes
        Game game = new Game();
        game.start();
    }

    public void start() {
        int targetFPS = 60;
        // 60 FPS
        long targetTimePerFrame = 1000 / targetFPS;
        initialize();

        while (isGameRunning) {
            long startTime = System.currentTimeMillis();
            update();
            render();
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

        cleanup();
    }

<<<<<<< Updated upstream
    private void initialize() {
        // Perform any initialization tasks here
    }

    private void update() {
        // Update the game state (handle input, move characters, check collisions, etc.)
    }

    private void render() {
        // Render the current state of the game to the screen
    }

    private void cleanup() {
        // Perform any cleanup tasks here
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
=======
    public State getState(){ return this.state;}
    public int getLevelUnlocks(){return this.levelUnlocks;}
    public void setLevelUnlocks(int levelUnlocks){ this.levelUnlocks = levelUnlocks;}

    public static List<HiscoreEntry> getHiscores() {
        return hiscores;
    }

    public void setHiscores(List<HiscoreEntry> hiscores) {
        Game.hiscores = hiscores;
>>>>>>> Stashed changes
    }
}
