package com.l09gr01.badice.model.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.utils.HiscoreEntry;
import com.l09gr01.badice.utils.HiscoresManager;

import java.util.Arrays;
import java.util.List;

public class HiscoresMenu extends Menu {
    private static List<HiscoreEntry> hiscores = HiscoresManager.loadHiscores("data/hiscores.txt");
    public HiscoresMenu() {
        super();
        this.entries = Arrays.asList("OK");
    }

    public boolean isSelectedBack() {
        return isSelected(0);
    }
    public List<HiscoreEntry> getHiscores() {
        return hiscores;
    }
}

