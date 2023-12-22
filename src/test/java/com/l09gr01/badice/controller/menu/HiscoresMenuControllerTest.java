package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.menu.HiscoresMenu;
import com.l09gr01.badice.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;

public class HiscoresMenuControllerTest {
    private HiscoresMenuController hiscoresMenuController;
    private Game game;
    @BeforeEach
    void setUp() {
        HiscoresMenu hiscoresMenu = new HiscoresMenu();
        hiscoresMenuController = new HiscoresMenuController(hiscoresMenu);
        game = Mockito.mock(Game.class);
    }
    @Test
    void okSelectedTest() throws IOException {
        hiscoresMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
}
