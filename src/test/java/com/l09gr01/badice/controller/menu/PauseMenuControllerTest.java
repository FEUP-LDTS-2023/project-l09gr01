package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.menu.PauseMenu;
import com.l09gr01.badice.state.GameState;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.state.OptionsMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;

public class PauseMenuControllerTest {
    private PauseMenuController pauseMenuController;
    private Game game;
    private Arena arena;


    @BeforeEach
    void setUp() {
        arena = Mockito.mock(Arena.class);
        game = Mockito.mock(Game.class);
        PauseMenu pauseMenu = new PauseMenu(arena);
        pauseMenuController = new PauseMenuController(pauseMenu);
    }
    @Test
    void selectedResumeTest() throws IOException {
        pauseMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(GameState.class));
    }
    @Test
    void selectedOptionsTest() throws IOException  {
        pauseMenuController.step(game, GUI.ACTION.DOWN,0);
        pauseMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(OptionsMenuState.class));
    }
    @Test
    void selectedQuitTest() throws IOException {
        pauseMenuController.step(game, GUI.ACTION.UP,0);
        pauseMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
}
