package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.menu.LevelCompletedMenu;
import com.l09gr01.badice.state.GameState;
import com.l09gr01.badice.state.LevelSelectMenuState;
import com.l09gr01.badice.state.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;
import static org.mockito.Mockito.verify;

public class LevelCompletedMenuControllerTest {
    private Game game;
    private LevelCompletedMenuController levelCompletedMenuController;

    @BeforeEach
    void setUp() {
        LevelCompletedMenu levelCompletedMenu = new LevelCompletedMenu(3,"06:22",6000);
        levelCompletedMenuController = new LevelCompletedMenuController(levelCompletedMenu);
        game = Mockito.mock(Game.class);
    }
    @Test
    void tryAgainTest() throws IOException {
        LevelCompletedMenu levelCompletedMenu = new LevelCompletedMenu(5,"11:21",11000);
        levelCompletedMenuController = new LevelCompletedMenuController(levelCompletedMenu);
        levelCompletedMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(GameState.class));
    }
    @Test
    void selectedNextLevelTest() throws IOException {
        levelCompletedMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(GameState.class));
    }
    @Test
    void selectedChooseLevelTest() throws IOException {
        levelCompletedMenuController.step(game, GUI.ACTION.DOWN,0);
        levelCompletedMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(LevelSelectMenuState.class));
    }
    @Test
    void selectedMainMenuTest() throws IOException {
        levelCompletedMenuController.step(game, GUI.ACTION.DOWN,0);
        levelCompletedMenuController.step(game, GUI.ACTION.DOWN,0);
        levelCompletedMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
    @Test
    void selectedQuitTest() throws IOException {
        levelCompletedMenuController.step(game, GUI.ACTION.UP,0);
        levelCompletedMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(ArgumentMatchers.isNull());
    }
}
