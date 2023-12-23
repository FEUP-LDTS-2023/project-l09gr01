package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.Ice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IceViewTest {
    private Ice ice;
    private IceView view;
    private GUI gui;

    @BeforeEach
    void setup(){
        ice = new Ice(10,10);
        view = new IceView();
        gui = Mockito.mock(GUI.class);

    }
    @Test
    void drawElement(){
        view.draw(ice, gui);
        Mockito.verify(gui, Mockito.times(1)).drawIce(ice.getPosition());
    }
}
