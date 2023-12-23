package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.PlayerCharacter;
import com.l09gr01.badice.view.game.PlayerCharacterView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerCharacterViewTest {
    private PlayerCharacter playerCharacter;
    private PlayerCharacterView view;
    private GUI gui;

    @BeforeEach
    void setUp() {
        playerCharacter = new PlayerCharacter(10, 10);
        view = new PlayerCharacterView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        view.draw(playerCharacter, gui);
        Mockito.verify(gui, Mockito.times(1)).drawUpPlayerCharacter(playerCharacter.getPosition());
    }
}