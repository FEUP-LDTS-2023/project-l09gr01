package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.FruitInIce;

public class FruitInIceView implements ElementView<FruitInIce>{
    @Override
    public void draw(FruitInIce fruitInIce, GUI gui) {
        gui.drawFruitInIce(fruitInIce.getPosition());
    }
}
