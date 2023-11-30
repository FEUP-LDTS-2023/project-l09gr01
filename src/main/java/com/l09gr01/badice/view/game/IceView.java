package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.Ice;

public class IceView implements ElementView<Ice> {
    @Override
    public void draw(Ice ice, GUI gui) {
        gui.drawIce(ice.getPosition());
    }
}
