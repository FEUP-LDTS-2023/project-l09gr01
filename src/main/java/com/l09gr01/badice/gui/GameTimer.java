package com.l09gr01.badice.gui;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer implements Comparable<GameTimer> {
    private final Timer timer;
    private int secondsElapsed;
    public boolean isPaused;
    private String formattedTime;
    private static final DecimalFormat df = new DecimalFormat("00");

    public GameTimer() {
        this.secondsElapsed = 0;
        this.isPaused = false;
        this.formattedTime = "00:00";
        this.timer = new Timer();
    }
    public GameTimer(String timer) {
        this.secondsElapsed = parseTimerToSeconds(timer);
        this.formattedTime = timer;
        this.timer = new Timer();
        this.isPaused = true;
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!isPaused) {
                    secondsElapsed++;
                    int minutes = secondsElapsed / 60;
                    int seconds = secondsElapsed % 60;
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
    public static String addTimers(String timer1, String timer2) {
            int seconds1 = parseTimerToSeconds(timer1);
            int seconds2 = parseTimerToSeconds(timer2);
            int sumSeconds = seconds1 + seconds2;

            int minutes = sumSeconds / 60;
            int seconds = sumSeconds % 60;
            return df.format(minutes) + ":" + df.format(seconds);
    }
    private static int parseTimerToSeconds(String timer) {
        if (timer == null) return 0;
        String[] parts = timer.split(":");

        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);

        return minutes * 60 + seconds;
    }
    public int compareTo(GameTimer other){
        return Integer.compare(this.secondsElapsed, other.secondsElapsed);
    }
}