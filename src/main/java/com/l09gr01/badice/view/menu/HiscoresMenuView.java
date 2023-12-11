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
        List<HiscoreEntry> hiscores = getModel().getHiscores();
        for (int i = 0; i < hiscores.size(); i++) {
            HiscoreEntry entry = hiscores.get(i);
            gui.drawText(new Position(5, 7 + i),
                    entry.getRank() + ". " + entry.getName() + " - " + entry.getScore() + " - " + entry.getTime(), "#FFFFFF");
        }

    }
}
