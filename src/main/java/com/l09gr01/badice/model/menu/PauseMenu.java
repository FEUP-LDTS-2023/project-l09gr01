package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class PauseMenu extends Menu {

    public PauseMenu() {
        super();
        this.entries = Arrays.asList("Resume Game","Options","Quit Game");
    }

    public boolean isSelectedResume() {
        return isSelected(0);
    }
    public boolean isSelectedOptions() {
        return isSelected(1);
    }
    public boolean isSelectedQuit() {
        return isSelected(2);
    }
}
