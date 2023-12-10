package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.InstructionsMenu;
import com.l09gr01.badice.model.menu.LevelCompletedMenu;
import com.l09gr01.badice.view.View;

public class LevelCompletedMenuView extends View<LevelCompletedMenu> {
    public LevelCompletedMenuView(LevelCompletedMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "LEVEL COMPLETE!", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
