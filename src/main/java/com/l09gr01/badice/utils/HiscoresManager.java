package com.l09gr01.badice.utils;

import java.util.List;
import com.l09gr01.badice.Game;

public class HiscoresManager {
    public static int findIndexToInsert(List<HiscoreEntry> hiscores, int score, String time) {
        for (int i = 0; i < hiscores.size(); i++) {
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
        return hiscores.size(); // Insert at the end if no suitable position is found
    }
    public void addHiscoreEntry(List<HiscoreEntry> hiscores, HiscoreEntry hiscoreEntry){
        hiscores = Game.getHiscores();
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
}
