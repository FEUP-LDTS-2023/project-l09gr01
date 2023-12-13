package com.l09gr01.badice.model.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class LevelSelectMenu extends Menu{

    public LevelSelectMenu() {
        super();
        this.entries = new ArrayList<>();
        for (int i = 1; i <= getMaxLevel(); i++){
            this.entries.add("LEVEL " + i);
        }
        this.entries.add("BACK TO MAIN MENU");
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
    public boolean isSelectedLevel4() {
        return isSelected(3);
    }
    public boolean isSelectedLevel5() {
        return isSelected(4);
    }
    public boolean isSelectedBack() {
        return isSelected(5);
    }
}
