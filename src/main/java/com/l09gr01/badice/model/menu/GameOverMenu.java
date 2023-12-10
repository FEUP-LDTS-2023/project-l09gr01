package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class GameOverMenu extends Menu {
    private int level;
    public GameOverMenu(int level) {
        super();
        this.entries = Arrays.asList("TRY AGAIN", "CHOOSE LEVEL", "MAIN MENU", "QUIT");
        this.level = level;
    }

    public boolean isSelectedTryAgain() {
        return isSelected(0);
    }
    public boolean isSelectedChooseLevel() { return isSelected(1);}
    public boolean isSelectedMainMenu() { return isSelected(2);}
    public boolean isSelectedQuit() { return isSelected(3);}
    public int getLevel(){
        return this.level;
    }
}
