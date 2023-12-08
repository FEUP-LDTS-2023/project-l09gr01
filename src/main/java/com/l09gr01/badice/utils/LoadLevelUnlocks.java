package com.l09gr01.badice.utils;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadLevelUnlocks {
    public static int loadLevelUnlocks(String filePath) {
        int levelUnlocks = 1;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            levelUnlocks = dis.readInt();
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
