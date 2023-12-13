package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class InstructionsMenu extends Menu {

    public InstructionsMenu() {
        super();
        this.entries = Arrays.asList("BACK TO MAIN MENU");
    }

    public boolean isSelectedBack() {
        return isSelected(0);
    }
}
