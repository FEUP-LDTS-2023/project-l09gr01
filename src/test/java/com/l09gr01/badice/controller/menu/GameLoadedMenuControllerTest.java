package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.menu.GameLoadedMenu;
import com.l09gr01.badice.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class GameLoadedMenuControllerTest {
    private GameLoadedMenuController gameLoadedMenuController;
    private Game game;

    @BeforeEach
    void setUp() {
        GameLoadedMenu gameLoadedMenu = new GameLoadedMenu();
        gameLoadedMenuController = new GameLoadedMenuController(gameLoadedMenu);
        game = Mockito.mock(Game.class);
    }
    @Test
    void confirmSelectedTest() throws IOException {
        assertTrue(gameLoadedMenuController.getModel().isSelectedConfirm());
        gameLoadedMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
}
