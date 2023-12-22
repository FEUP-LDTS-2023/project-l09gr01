package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.menu.NewHiscoreMenu;
import com.l09gr01.badice.state.HiscoresMenuState;
import com.l09gr01.badice.utils.HiscoresManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NewHiscoresMenuControllerTest {
    private NewHiscoreMenuController newHiscoreMenuController;
    private Game game;
    private InputHandler gui;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        gui = Mockito.mock(InputHandler.class);
        NewHiscoreMenu newHiscoreMenu = new NewHiscoreMenu(6,10000,"06:00");
        newHiscoreMenuController = new NewHiscoreMenuController(newHiscoreMenu);
        when(game.getGui()).thenReturn(gui);
        HiscoresManager.setWasGamePlayed(true);
    }


    @Test
    void newHiscoreEntryTest() throws IOException {
        when(gui.getLastInputCharacter()).thenReturn('J');
        newHiscoreMenuController.step(game, GUI.ACTION.INPUT_CHAR,0);
        when(gui.getLastInputCharacter()).thenReturn('O');
        newHiscoreMenuController.step(game, GUI.ACTION.INPUT_CHAR,0);
        when(gui.getLastInputCharacter()).thenReturn('A');
        newHiscoreMenuController.step(game, GUI.ACTION.INPUT_CHAR,0);
        when(gui.getLastInputCharacter()).thenReturn('O');
        newHiscoreMenuController.step(game, GUI.ACTION.INPUT_CHAR,0);
        when(gui.getLastInputCharacter()).thenReturn('X');
        newHiscoreMenuController.step(game, GUI.ACTION.INPUT_CHAR,0);
        newHiscoreMenuController.step(game, GUI.ACTION.BACKSPACE,0);
        newHiscoreMenuController.step(game, GUI.ACTION.SELECT,0);
        assertEquals(newHiscoreMenuController.getModel().getNewName(),"JOAO");
        assertFalse(HiscoresManager.wasGamePlayed());
        verify(game).setState(Mockito.any(HiscoresMenuState.class));

    }

}
