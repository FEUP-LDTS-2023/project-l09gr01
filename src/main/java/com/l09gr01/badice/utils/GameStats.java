package com.l09gr01.badice.utils;

import com.l09gr01.badice.gui.GameTimer;

import java.util.ArrayList;
import java.util.List;

public class GameStats {
    private static int levelsUnlocked = 1;
    private static boolean isSelected2Players = false;
    private static List<HiscoreEntry> hiscores = HiscoresManager.loadHiscores("data/hiscores.txt");
    private static final List<String> levelTimers = new ArrayList<>();
    private static final List<Integer> levelScores = new ArrayList<>();
    public static int getLevelsUnlocked() {
        return levelsUnlocked;
    }

    public static void setLevelsUnlocked(int levelsUnlocked) {
        GameStats.levelsUnlocked = levelsUnlocked;
    }

    public static List<HiscoreEntry> getHiscores() {
        return hiscores;
    }

    public static void setHiscores(List<HiscoreEntry> hiscores) {
        GameStats.hiscores = hiscores;
    }

    public static String getTotalGameTime(){
        String totalGameTime = "00:00";
        for (String timer : levelTimers){
            totalGameTime = GameTimer.addTimers(totalGameTime, timer);
        }
        return totalGameTime;
    }

    public static String getLevelTimer(int level){
        while (level-1 >= levelTimers.size()) {
            levelTimers.add(null);
        }
        return levelTimers.get(level-1);
    }
    public static int getLevelScore(int level){
        while (level-1 >= levelScores.size()) {
            levelScores.add(0);
        }
        return levelScores.get(level-1);
    }
    public static void setLevelScore(int level, int score){
        while (level-1 >= levelScores.size()) {
            levelScores.add(0);
        }
        levelScores.set(level-1, score);
    }

    public static void setLevelTimer(int level, String time){
        while (level-1 >= levelTimers.size()) {
            levelTimers.add(null);
        }
        levelTimers.set(level-1,time);
    }

    public static int getTotalScore() {
        int totalScore = 0;
        for (int levelScore : levelScores) totalScore += levelScore;
        return totalScore;
    }

    public static boolean isSelected2Players() {
        return isSelected2Players;
    }

    public static void setSelected2Players(boolean selected2Players) {
        isSelected2Players = selected2Players;
    }
    public static void resetGame(){
        levelsUnlocked = 1;
        levelTimers.clear();
        levelScores.clear();
    }
}
