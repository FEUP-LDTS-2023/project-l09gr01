package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class OptionsMenu extends Menu {

    public OptionsMenu() {
        super();
        this.entries = Arrays.asList("Back To Main Menu");
    }

    public boolean isSelectedBack() {
        return isSelected(0);
    }
}
