package com.l09gr01.badice.utils;

import java.io.*;

public class SaveGameStats {
    public static void saveGameStats(int levelUnlocks, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 1; i < levelUnlocks; i++) {
                writer.write((i) + " " + GameStats.getLevelTimer(i) + " " + GameStats.getLevelScore(i));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception here
        }
    }
}