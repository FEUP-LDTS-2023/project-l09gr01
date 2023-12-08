package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class NewHiscoreMenu extends Menu {
    private int newRank;
    private int newScore;
    private String newTime;
    public NewHiscoreMenu(int newRank, int newScore, String newTime) {
        super();
        this.entries = Arrays.asList("INSERT NAME", "A");
    }

    public boolean isSelectedInsertName() {
        return isSelected(0);
    }

    public int getNewRank() {
        return newRank;
    }

    public int getNewScore() {
        return newScore;
    }

    public String getNewTime() {
        return newTime;
    }
}
