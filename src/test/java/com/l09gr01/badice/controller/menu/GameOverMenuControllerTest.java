package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.menu.GameOverMenu;
import com.l09gr01.badice.state.GameState;
import com.l09gr01.badice.state.LevelSelectMenuState;
import com.l09gr01.badice.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;

public class GameOverMenuControllerTest {
    private Game game;
    private GameOverMenuController gameOverMenuController;

    @BeforeEach
    void setUp() {
        GameOverMenu gameOverMenu = new GameOverMenu(2, "05:00",3000);
        gameOverMenuController = new GameOverMenuController(gameOverMenu);
        game = Mockito.mock(Game.class);
    }
    @Test
    void tryAgainTest() throws IOException {
        gameOverMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(GameState.class));
    }
    @Test
    void chooseLevelTest() throws IOException {
        gameOverMenuController.step(game, GUI.ACTION.DOWN,0);
        gameOverMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(LevelSelectMenuState.class));
    }
    @Test
    void selectMainMenuTest() throws IOException {
        gameOverMenuController.step(game, GUI.ACTION.DOWN,0);
        gameOverMenuController.step(game, GUI.ACTION.DOWN,0);
        gameOverMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
    @Test
    void selectQuitTest() throws IOException {
        gameOverMenuController.step(game, GUI.ACTION.UP,0);
        gameOverMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(ArgumentMatchers.isNull());
    }
}
