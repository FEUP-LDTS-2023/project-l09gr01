package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.OptionsMenu;
import com.l09gr01.badice.utils.GameStats;
import com.l09gr01.badice.view.View;

public class OptionsMenuView extends View<OptionsMenu> {
    public OptionsMenuView(OptionsMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "OPTIONS", "#FFFFFF");

        if(getModel().getPausedArena() == null) gui.drawText(new Position(5, 7),
            getModel().getEntry(0) + " " + GameStats.isSelected2Players(),
            getModel().isSelected(0) ? "#FFD700" : "#FFFFFF");
        else gui.drawText(new Position(5, 7),
                getModel().getEntry(0),
                getModel().isSelected(0) ? "#FFD700" : "#FFFFFF");
        for (int i = 1; i < 11; i++) {
            gui.drawText(new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
            gui.drawText(new Position(23, 7 + i),
                    KeybindManager.getKeyString(KeybindManager.getEditableAction(i-1)),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
        gui.drawText(new Position(5, 19),
                getModel().getEntry(11) + " NOT IMPLEMENTED ",
                getModel().isSelected(11) ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(5, 20),
                getModel().getEntry(12) + " NOT IMPLEMENTED ",
                getModel().isSelected(12) ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(5, 22),
                getModel().getEntry(13),
                getModel().isSelected(13) ? "#FFD700" : "#FFFFFF");
    }
}
