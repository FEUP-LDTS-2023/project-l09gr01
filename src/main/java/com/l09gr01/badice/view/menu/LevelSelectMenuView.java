package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.LevelSelectMenu;
import com.l09gr01.badice.utils.GameStats;
import com.l09gr01.badice.view.View;

public class LevelSelectMenuView extends View<LevelSelectMenu> {
    public LevelSelectMenuView(LevelSelectMenu menu) {
        super(menu);
    }

    private int numEntries = getModel().getNumberEntries();

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "SELECT LEVEL", "#FFFFFF");

        for (int i = 0; i < numEntries - 1; i++) {
            if (GameStats.getLevelsUnlocked() > i) {
                if (GameStats.getLevelTimer(i+1) == null)
                    gui.drawText(new Position(5, 7 + i), getModel().getEntry(i) + " NOT COMPLETED", getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
                else gui.drawText(new Position(5, 7 + i), getModel().getEntry(i) + " BEST TIME: " + GameStats.getLevelTimer(i + 1), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
            } else gui.drawText(new Position(5, 7 + i), getModel().getEntry(i) + " LOCKED", getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
        gui.drawText(new Position(5, 8 + numEntries), getModel().getEntry(numEntries-1), getModel().isSelected(numEntries-1) ? "#FFD700" : "#FFFFFF");
    }
}
