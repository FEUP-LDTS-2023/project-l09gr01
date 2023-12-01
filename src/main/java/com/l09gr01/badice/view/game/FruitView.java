package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.Fruit;

public class FruitView implements ElementView<Fruit> {
    @Override
    public void draw(Fruit fruit, GUI gui) {
        gui.drawFruit(fruit.getPosition());
    }
}
