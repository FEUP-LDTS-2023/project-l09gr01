package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.GameLoadedMenu;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.view.View;

public class GameLoadedMenuView extends View<GameLoadedMenu> {
    public GameLoadedMenuView(GameLoadedMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "PROGRESS LOADED", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
