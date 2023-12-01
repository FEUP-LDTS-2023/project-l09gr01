package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.Element;

public interface ElementView<T extends Element> {
    void draw(T element, GUI gui);
}
