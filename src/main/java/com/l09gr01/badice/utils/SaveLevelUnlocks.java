package com.l09gr01.badice.utils;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveLevelUnlocks {
    public static void saveLevelUnlocks(int levelUnlocks, String filePath) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(levelUnlocks);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception here
        }
    }
}
