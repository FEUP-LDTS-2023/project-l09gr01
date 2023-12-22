package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.menu.GameSavedMenu;
import com.l09gr01.badice.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class GameSavedMenuControllerTest {
    private GameSavedMenuController gameSavedMenuController;
    private Game game;

    @BeforeEach
    void setUp() {
        GameSavedMenu gameSavedMenu = new GameSavedMenu();
        gameSavedMenuController = new GameSavedMenuController(gameSavedMenu);
        game = Mockito.mock(Game.class);
    }
    @Test
    void confirmSelectedTest() throws IOException {
        assertTrue(gameSavedMenuController.getModel().isSelectedConfirm());
        gameSavedMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
}
