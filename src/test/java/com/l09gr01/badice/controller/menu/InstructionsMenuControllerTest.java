package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.menu.InstructionsMenu;
import com.l09gr01.badice.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class InstructionsMenuControllerTest {
    private InstructionsMenuController instructionsMenuController;
    private Game game;

    @BeforeEach
    void setUp() {
        InstructionsMenu instructionsMenu = new InstructionsMenu();
        instructionsMenuController = new InstructionsMenuController(instructionsMenu);
        game = Mockito.mock(Game.class);
    }
    @Test
    void backSelectedTest() throws IOException {
        assertTrue(instructionsMenuController.getModel().isSelectedBack());
        instructionsMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
}
