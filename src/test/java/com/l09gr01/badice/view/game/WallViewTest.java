package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WallViewTest {
    private Wall wall;
    private WallView view;
    private GUI gui;

    @BeforeEach
    void setUp(){
        wall = new Wall(10,10);
        view = new WallView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement(){
        view.draw(wall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
    }
}
