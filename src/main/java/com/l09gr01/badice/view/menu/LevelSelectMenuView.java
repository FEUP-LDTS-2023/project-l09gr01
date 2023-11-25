package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.LevelSelectMenu;
import com.l09gr01.badice.model.menu.Menu;
import com.l09gr01.badice.view.View;

public class LevelSelectMenuView extends View<LevelSelectMenu> {
    public LevelSelectMenuView(LevelSelectMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
