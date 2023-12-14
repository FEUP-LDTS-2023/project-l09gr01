package com.l09gr01.badice.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.l09gr01.badice.Game;

public class HiscoresManager {

    public static boolean wasGamePlayed = false;    // flag to check if a new game was played and
    // the levelTimers and levelScores were updated (so we don't always get newHiscoreMenu everytime
    // we go in and out of ChooseLevelMenu
    public static int getLowestRank() { // can just change return value incase
        return 10;                      // we want to add more hiscore entries later
    }
    public static boolean isNewHiscore(int score, String time){
        if (time == null) return false;
        return findIndexToInsert(GameStats.getHiscores(),score,time) < getLowestRank();
    }
    public static int findIndexToInsert(List<HiscoreEntry> hiscores, int score, String time) {
        for (int i = 0; i < getLowestRank(); i++) {
            HiscoreEntry currentEntry = hiscores.get(i);
            if (score > currentEntry.getScore()) {
                return i;
            } else if (score == currentEntry.getScore()) {
                if (compareTimes(time, currentEntry.getTime()) < 0) {
                    return i;
                }
            }
        }
        return getLowestRank(); // isNewHiscore will be false
    }
    public static List<HiscoreEntry> addHiscoreEntry(List<HiscoreEntry> hiscores, HiscoreEntry hiscoreEntry){
        int rank = hiscoreEntry.getRank();
        for (int i = rank - 1; i < getLowestRank();i++){
            HiscoreEntry tempEntry = hiscores.get(i);
            tempEntry.setRank(tempEntry.getRank()+1);
            hiscores.set(i,hiscoreEntry);
            hiscoreEntry = tempEntry;
        }
        return hiscores;
    }

    private static int compareTimes(String time1, String time2) {
        String[] parts1 = time1.split(":");
        String[] parts2 = time2.split(":");
        int hours1 = Integer.parseInt(parts1[0]);
        int minutes1 = Integer.parseInt(parts1[1]);
        int hours2 = Integer.parseInt(parts2[0]);
        int minutes2 = Integer.parseInt(parts2[1]);

        if (hours1 != hours2) {
            return Integer.compare(hours1, hours2);
        } else {
            return Integer.compare(minutes1, minutes2);
        }
    }
    public static void saveHiscores(List<HiscoreEntry> hiscores, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (HiscoreEntry entry : hiscores) {
                writer.write(entry.getRank() + ". " + entry.getName() + " " + entry.getScore() + " " + entry.getTime());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<HiscoreEntry> loadHiscores(String filePath) {
        List<HiscoreEntry> hiscores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 4) {
                    int rank = Integer.parseInt(parts[0].replace(".", ""));
                    String name = parts[1];
                    int score = Integer.parseInt(parts[2]);
                    String time = parts[3];
                    hiscores.add(new HiscoreEntry(rank, name, score, time));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hiscores;

        }
    public static boolean wasGamePlayed(){
        return wasGamePlayed;
    }

    public static void setWasGamePlayed(boolean gameWasPlayed) {
        HiscoresManager.wasGamePlayed = gameWasPlayed;
    }
}


