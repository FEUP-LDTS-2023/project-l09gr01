package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class LevelSelectMenu extends Menu{

    public LevelSelectMenu() {
        super();
        this.entries = Arrays.asList("Level 1", "Level 2", "Level 3", "Back To Main Menu");
    }
    public boolean isSelectedLevel1() {
        return isSelected(0);
    }
    public boolean isSelectedLevel2() {
        return isSelected(1);
    }
    public boolean isSelectedLevel3() {
        return isSelected(2);
    }
    public boolean isSelectedBack() {
        return isSelected(3);
    }
}
