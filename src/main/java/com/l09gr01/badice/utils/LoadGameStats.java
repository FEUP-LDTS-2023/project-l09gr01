package com.l09gr01.badice.utils;

import java.io.*;

public class LoadGameStats {
    public static void loadGameStats(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                int level = Integer.parseInt(parts[0]);
                String time = parts[1];
                int score = Integer.parseInt(parts[2]);
                GameStats.setLevelTimer(level,time);
                GameStats.setLevelsUnlocked(GameStats.getLevelsUnlocked()+ 1);
                GameStats.setLevelScore(level,score);
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            e.printStackTrace();
        } catch (IOException e) {
            // Handle other IOExceptions
            e.printStackTrace();
        }
    }
}
