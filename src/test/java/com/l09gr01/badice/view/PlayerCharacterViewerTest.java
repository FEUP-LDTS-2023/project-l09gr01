package com.l09gr01.badice.view;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.model.game.elements.PlayerCharacter;
import com.l09gr01.badice.view.game.PlayerCharacterView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerCharacterViewerTest {
    private PlayerCharacter playerCharacter;
    private PlayerCharacterView viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        playerCharacter = new PlayerCharacter(10, 10);
        viewer = new PlayerCharacterView();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(playerCharacter, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayerCharacter(playerCharacter.getPosition());
    }
}