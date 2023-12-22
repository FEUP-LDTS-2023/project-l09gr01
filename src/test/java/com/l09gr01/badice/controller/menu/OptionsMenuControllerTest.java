package com.l09gr01.badice.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.menu.OptionsMenu;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.state.PauseMenuState;
import com.l09gr01.badice.state.State;
import com.l09gr01.badice.utils.GameStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OptionsMenuControllerTest {
    private OptionsMenuController optionsMenuController;
    private Game game;
    private State state;
    private InputHandler gui;
    private Arena arena;

    @BeforeEach
    void setUp() {
        OptionsMenu optionsMenu = new OptionsMenu();
        optionsMenuController = new OptionsMenuController(optionsMenu);
        game = Mockito.mock(Game.class);
        state = Mockito.mock(State.class);
        gui = Mockito.mock(InputHandler.class);
        arena = Mockito.mock(Arena.class);
        when(game.getState()).thenReturn(state);
        when(game.getGui()).thenReturn(gui);

    }

    @Test
    void toggle2PlayerModeTest() throws IOException {
        assertTrue(optionsMenuController.getModel().isSelected2PlayerMode());
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(state).refreshView(gui);
        assertTrue(GameStats.isSelected2Players());
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertFalse(GameStats.isSelected2Players());
    }

    @Test
    void setP1MoveUpTest() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('I', false, false));
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.MOVE_UP), "I");
    }

    @Test
    void setP1MoveDownTest() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('K', false, false));
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.MOVE_DOWN), "K");
    }

    @Test
    void setP1MoveLeftTest() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('J', false, false));
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.MOVE_LEFT), "J");
    }

    @Test
    void setP1MoveRightTest() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('L', false, false));
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.MOVE_RIGHT), "L");
    }

    @Test
    void setP1Action() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('I', false, false));
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.P1ACTION), "I");
    }

    @Test
    void setP2MoveUp() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('I', false, false));
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.P2UP), "I");
    }

    @Test
    void setP2MoveDown() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('I', false, false));
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.P2DOWN), "I");
    }

    @Test
    void setP2MoveLeft() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('I', false, false));
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.P2LEFT), "I");
    }

    @Test
    void setP2MoveRight() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('I', false, false));
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.P2RIGHT), "I");
    }

    @Test
    void setP2Action() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('I', false, false));
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.P2ACTION), "I");
    }

    @Test
    void selectMainMenu() throws IOException {
        optionsMenuController.step(game, GUI.ACTION.UP, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(MainMenuState.class));
    }

    @Test
    void selectResume() throws IOException {
        OptionsMenu optionsMenu1 = new OptionsMenu(arena);
        optionsMenuController = new OptionsMenuController(optionsMenu1);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(PauseMenuState.class));
    }

    @Test
    void overwriteKeyBindTest() throws IOException {
        when(gui.getUserInput()).thenReturn(new KeyStroke('S', false, false));
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.DOWN, 0);
        optionsMenuController.step(game, GUI.ACTION.SELECT, 0);
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.MOVE_DOWN), "S");
        assertEquals(KeybindManager.getKeyString(GUI.ACTION.P2DOWN), "NOT ASSIGNED");
    }
    @Test
    void selectPressedTest() throws IOException {
        OptionsMenu optionsMenu2 = Mockito.mock(OptionsMenu.class);
        OptionsMenuController optionsMenuController2 = new OptionsMenuController(optionsMenu2);
        optionsMenuController2.step(game, GUI.ACTION.SELECT, 0);
        verify(optionsMenu2,times(2)).setSelectPressed();
    }
}
