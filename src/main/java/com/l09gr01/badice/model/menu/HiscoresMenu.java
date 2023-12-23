package com.l09gr01.badice.model.menu;

import com.l09gr01.badice.utils.GameStats;
import com.l09gr01.badice.utils.HiscoreEntry;

import java.util.Arrays;
import java.util.List;

public class HiscoresMenu extends Menu {
    private static List<HiscoreEntry> hiscores = GameStats.getHiscores();
    public HiscoresMenu() {
        super();
        this.entries = Arrays.asList("OK");
    }
    public boolean isSelectedOk() {
        return isSelected(0);
    }
    public List<HiscoreEntry> getHiscores() {
        return hiscores;
    }

}

