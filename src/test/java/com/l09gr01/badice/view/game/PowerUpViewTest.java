package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.PowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerUpViewTest {
    private PowerUp powerUp;
    private PowerUpView view;
    private GUI gui;

    @BeforeEach
    void setUp(){
        powerUp = new PowerUp(10,10);
        view = new PowerUpView();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawElement(){
        view.draw(powerUp, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPowerUp(powerUp.getPosition());
    }
}
