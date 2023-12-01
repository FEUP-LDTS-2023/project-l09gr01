package com.l09gr01.badice.gui;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    private final Timer timer;
    private int secondsElapsed;
    private boolean isPaused;
    private String formattedTime;

    public GameTimer() {
        this.secondsElapsed = 0;
        this.isPaused = false;
        this.formattedTime = "00:00";
        this.timer = new Timer();
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!isPaused) {
                    secondsElapsed++;
                    int minutes = secondsElapsed / 60;
                    int seconds = secondsElapsed % 60;

                    // Format the time as MM:SS
                    DecimalFormat df = new DecimalFormat("00");
                    formattedTime = df.format(minutes) + ":" + df.format(seconds);
                }
            }
        }, 0, 1000); // Schedule the task to run every 1000 milliseconds (1 second)
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }

    public String getFormattedTime() {
        return formattedTime;
    }
}