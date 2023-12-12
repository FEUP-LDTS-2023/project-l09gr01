package com.l09gr01.badice.model.menu;

import com.l09gr01.badice.utils.HiscoreEntry;

import java.util.Arrays;

public class NewHiscoreMenu extends Menu {
    private final int newRank;
    private final int newScore;
    private final String newTime;
    private String newName;
    public NewHiscoreMenu(int newRank, int newScore, String newTime) {
        super();
        this.newRank = newRank;
        this.newScore = newScore;
        this.newTime = newTime;
        this.entries = Arrays.asList("INSERT NAME", "");
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }
    public HiscoreEntry createHiscoreEntry(){
        return new HiscoreEntry(this.getNewRank(),this.getNewName(),this.getNewScore(),this.getNewTime());
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
