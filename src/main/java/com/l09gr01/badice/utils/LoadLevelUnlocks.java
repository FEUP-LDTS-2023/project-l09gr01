package com.l09gr01.badice.utils;

import java.io.*;

public class LoadLevelUnlocks {
    public static int loadLevelUnlocks(String filePath) {
        int levelUnlocks = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                levelUnlocks = Integer.parseInt(line);
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            e.printStackTrace();
        } catch (IOException e) {
            // Handle other IOExceptions
            e.printStackTrace();
        }
        return levelUnlocks;
    }
}
