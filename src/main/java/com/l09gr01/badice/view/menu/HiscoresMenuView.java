package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.HiscoresMenu;
import com.l09gr01.badice.utils.HiscoreEntry;
import com.l09gr01.badice.view.View;

import java.util.List;

public class HiscoresMenuView extends View<HiscoresMenu> {

    public HiscoresMenuView(HiscoresMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "HISCORES", "#FFFFFF");
        gui.drawText(new Position(8, 7), "NAME", "#FFFFFF");
        gui.drawText(new Position(20, 7), "SCORE", "#FFFFFF");
        gui.drawText(new Position(30, 7), "TIME", "#FFFFFF");
        List<HiscoreEntry> hiscores = getModel().getHiscores();
        for (int i = 0; i < hiscores.size(); i++) {
            HiscoreEntry entry = hiscores.get(i);
            gui.drawText(new Position(5, 9 + i),
                    entry.getRank() + ".", "#FFFFFF");
            gui.drawText(new Position(8, 9 + i),
                    entry.getName(), "#FFFFFF");
            gui.drawText(new Position(18, 9 + i),
                    "- " + entry.getScore(), "#FFFFFF");
            gui.drawText(new Position(27, 9 + i),
                    "- " + entry.getTime(), "#FFFFFF");
        }
        gui.drawText(new Position(5, 21), getModel().getEntry(0),"#FFD700" );
    }
}
