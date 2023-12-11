package com.l09gr01.badice.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.l09gr01.badice.Game;

public class HiscoresManager {
    public static int getLowestRank() {
        return 10;
    }
    public static boolean isNewHiscore(int score, String time){
        return findIndexToInsert(GameStats.getHiscores(),score,time) < getLowestRank();
    }
    public static int findIndexToInsert(List<HiscoreEntry> hiscores, int score, String time) {
        for (int i = 0; i < getLowestRank(); i++) {
            HiscoreEntry currentEntry = hiscores.get(i);

            // Compare scores
            if (score > currentEntry.getScore()) {
                return i; // Insert before the current entry
            } else if (score == currentEntry.getScore()) {
                // If scores are equal, compare times
                if (compareTimes(time, currentEntry.getTime()) < 0) {
                    return i; // Insert before the current entry
                }
            }
        }
        return getLowestRank(); // Insert at the end if no suitable position is found
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
        // Implement logic to compare time strings, assuming format HH:mm
        // For simplicity, let's assume they are in the format "HH:mm" for this example.
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
            // Handle IOException, which might occur during file operations
            // You might want to log the error or provide user-friendly feedback
            e.printStackTrace();
        }
    }

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
