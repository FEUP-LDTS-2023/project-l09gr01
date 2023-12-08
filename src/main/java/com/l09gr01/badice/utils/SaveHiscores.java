package com.l09gr01.badice.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class SaveHiscores {
    public static void saveHiscores(List<HiscoreEntry> hiscores, String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (HiscoreEntry entry : hiscores) {
                writer.println(entry.getRank() + ". " + entry.getName() + " " + entry.getScore() + " " + entry.getTime());
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            e.printStackTrace();
        }
    }
}
