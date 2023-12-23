package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.Fruit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FruitViewTest {
    private Fruit fruit;
    private FruitView view;
    private GUI gui;

    @BeforeEach
    void setUp(){
        fruit = new Fruit(10,10);
        view = new FruitView();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawElement(){
        view.draw(fruit, gui);
        Mockito.verify(gui, Mockito.times(1)).drawFruit(fruit.getPosition());
    }
}
