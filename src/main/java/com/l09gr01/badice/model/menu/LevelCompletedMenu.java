package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class LevelCompletedMenu extends Menu{
    private int nextLevel;
    public LevelCompletedMenu(int nextLevel) {
        super();
        this.entries = Arrays.asList("NEXT LEVEL", "CHOOSE LEVEL", "MAIN MENU", "QUIT");
        this.nextLevel = nextLevel;
    }

    public boolean isSelectedNextLevel() {return isSelected(0);}
    public boolean isSelectedChooseLevel() {return isSelected(1);}
    public boolean isSelectedMainMenu() {return isSelected(2);}
    public boolean isSelectedQuit() {return isSelected(3);}

    public int getNextLevel() {
        return nextLevel;
    }
}
