package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class GameSavedMenu extends Menu {
    public GameSavedMenu() {
        super();
        this.entries = Arrays.asList("CONFIRM");
    }

    public boolean isSelectedConfirm() {
        return isSelected(0);
    }
}
