package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu{

    public MainMenu() {
        super();
        this.entries = Arrays.asList("New Game", "Load Game", "Instructions", "Hiscores", "Options", "Save Game", "Exit Game");
    }

    public boolean isSelectedNew() {
        return isSelected(0);
    }
    public boolean isSelectedLoad() {
        return isSelected(1);
    }
    public boolean isSelectedInstructions() {
        return isSelected(2);
    }
    public boolean isSelectedHiscores() {
        return isSelected(3);
    }
    public boolean isSelectedOptions() {
        return isSelected(4);
    }
    public boolean isSelectedSave() {
        return isSelected(5);
    }
    public boolean isSelectedExit() {
        return isSelected(6);
    }
}
