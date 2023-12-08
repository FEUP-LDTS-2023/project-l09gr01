package com.l09gr01.badice.model.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.utils.HiscoreEntry;

import java.util.Arrays;
import java.util.List;

public class HiscoresMenu extends Menu {
    private List<HiscoreEntry> hiscores = Game.getHiscores();
    public HiscoresMenu() {
        super();
        this.entries = Arrays.asList("OK");
    }

    public boolean isSelectedBack() {
        return isSelected(0);
    }
}

