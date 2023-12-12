package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class LevelCompletedMenu extends Menu{
    private final int level;
    private final String time;
    private final int score;
    public LevelCompletedMenu(int level, String time, int score) {
        super();
        this.entries = Arrays.asList("NEXT LEVEL", "CHOOSE LEVEL", "MAIN MENU", "QUIT");
        this.level = level;
        this.time = time;
        this.score = score;
    }

    public boolean isSelectedNextLevel() {return isSelected(0);}
    public boolean isSelectedChooseLevel() {return isSelected(1);}
    public boolean isSelectedMainMenu() {return isSelected(2);}
    public boolean isSelectedQuit() {return isSelected(3);}

    public int getLevel() {
        return level;
    }
    public String getTime() {return time;}
    public int getScore(){return score;}
}
