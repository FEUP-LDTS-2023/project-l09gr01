package com.l09gr01.badice.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LoadGameStats {
    public static void loadGameStats(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+",-1);
                int level = Integer.parseInt(parts[0]);
                String time = parts[1];
                int score = Integer.parseInt(parts[2]);
                GameStats.setLevelTimer(level,time);
                GameStats.setLevelsUnlocked(level+1);
                GameStats.setLevelScore(level,score);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
