package com.l09gr01.badice;

public class Game {     // Game loop. Starting point

    private boolean isGameRunning = true;

    public static void main(String[] args) {
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
    }
}
