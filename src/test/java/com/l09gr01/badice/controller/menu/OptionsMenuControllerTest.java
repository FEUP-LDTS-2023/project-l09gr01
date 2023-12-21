package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.menu.OptionsMenu;
import com.l09gr01.badice.state.State;
import com.l09gr01.badice.utils.GameStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OptionsMenuControllerTest {
    private OptionsMenuController optionsMenuController;
    private Game game;
    private State state;
    private InputHandler gui;
    @BeforeEach
    void setUp(){
        OptionsMenu optionsMenu = new OptionsMenu();
        optionsMenuController = new OptionsMenuController(optionsMenu);
        game = Mockito.mock(Game.class);
        state = Mockito.mock(State.class);
        gui = Mockito.mock(InputHandler.class);
        when(game.getState()).thenReturn(state);
        when(game.getGui()).thenReturn(gui);

    }
    @Test
    void toggle2PlayerModeTest() throws IOException {
        assertTrue(optionsMenuController.getModel().isSelected2PlayerMode());
        optionsMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(state).refreshView(gui);
        assertTrue(GameStats.isSelected2Players());
        optionsMenuController.step(game, GUI.ACTION.SELECT,0);
        assertFalse(GameStats.isSelected2Players());
    }
}
