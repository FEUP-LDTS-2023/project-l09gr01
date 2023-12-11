package com.l09gr01.badice.view.menu;

import com.googlecode.lanterna.gui2.TextBox;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.InstructionsMenu;
import com.l09gr01.badice.view.View;

public class InstructionsMenuView extends View<InstructionsMenu> {
    public InstructionsMenuView(InstructionsMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "INSTRUCTIONS", "#FFFFFF");
        gui.drawText(new Position(5,7),"Collect every piece of fruit ~", "#FFFFFF");
        gui.drawText(new Position(5,8),"as fast as possible.","#FFFFFF");
        gui.drawText(new Position(5,9),"The monsters | { } will melt you", "#FFFFFF");
        gui.drawText(new Position(5,10),"try to avoid them!", "#FFFFFF");
        gui.drawText(new Position(5,11),"Press SPACEBAR to destroy", "#FFFFFF");
        gui.drawText(new Position(5,12),"and create ice walls &&&", "#FFFFFF");
        gui.drawText(new Position(5,13),"Press ARROW KEYS to move $ % ^ _", "#FFFFFF");
        gui.drawText(new Position(5,14),"Check for hidden fruit @", "#FFFFFF");
        gui.drawText(new Position(5,15),"Find powerups * to get stronger", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 17 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
