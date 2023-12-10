package com.l09gr01.badice.utils;

import java.io.*;

public class SaveLevelUnlocks {
    public static void saveLevelUnlocks(int levelUnlocks, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(levelUnlocks));
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception here
        }
    }
}
