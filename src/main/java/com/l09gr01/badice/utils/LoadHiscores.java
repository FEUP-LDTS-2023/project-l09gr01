package com.l09gr01.badice.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadHiscores {
    public static List<HiscoreEntry> loadHiscores(String filePath) {
        List<HiscoreEntry> hiscores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the format is "RANK NAME SCORE TIME"
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
            // Handle the case where the file is not found
            e.printStackTrace();
        } catch (IOException e) {
            // Handle other IOExceptions
            e.printStackTrace();
        }
        return hiscores;
    }
}
