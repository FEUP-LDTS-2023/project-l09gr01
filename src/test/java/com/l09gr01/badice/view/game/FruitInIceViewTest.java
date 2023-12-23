package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.FruitInIce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FruitInIceViewTest {
    private FruitInIce fruitInIce;
    private FruitInIceView view;
    private GUI gui;

    @BeforeEach
    void setUp(){
        fruitInIce = new FruitInIce(10,10);
        view = new FruitInIceView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void DrawElement(){
        view.draw(fruitInIce, gui);
        Mockito.verify(gui, Mockito.times(1)).drawFruitInIce(fruitInIce.getPosition());
    }
}
