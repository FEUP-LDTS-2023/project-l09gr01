package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu{

    public MainMenu() {
        super();
        this.entries = Arrays.asList("NEW GAME","CHOOSE LEVEL", "LOAD GAME", "INSTRUCTIONS", "HISCORES", "OPTIONS", "SAVE GAME", "EXIT GAME");
    }

    public boolean isSelectedNew() {
        return isSelected(0);
    }
    public boolean isSelectedChooseLevel() {return isSelected(1);}
    public boolean isSelectedLoad() {
        return isSelected(2);
    }
    public boolean isSelectedInstructions() {
        return isSelected(3);
    }
    public boolean isSelectedHiscores() {
        return isSelected(4);
    }
    public boolean isSelectedOptions() {
        return isSelected(5);
    }
    public boolean isSelectedSave() {
        return isSelected(6);
    }
    public boolean isSelectedExit() {
        return isSelected(7);
    }
}
