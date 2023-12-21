package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.menu.LevelSelectMenu;
import com.l09gr01.badice.state.GameState;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.utils.GameStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class LevelSelectMenuControllerTest {
    private LevelSelectMenuController levelSelectMenuController;
    private Game game;

    @BeforeEach
    void setUp() {
        LevelSelectMenu levelSelectMenu = new LevelSelectMenu();
        levelSelectMenuController = new LevelSelectMenuController(levelSelectMenu);
        game = Mockito.mock(Game.class);
    }

    @Test
    void level1SelectedTest() throws IOException {
        GameStats.setLevelsUnlocked(1);
        assertTrue(levelSelectMenuController.getModel().isSelectedLevel1());
        levelSelectMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(GameState.class));
    }

    @Test
    void level2SelectedTest() throws IOException {
        GameStats.setLevelsUnlocked(2);
        levelSelectMenuController.step(game, GUI.ACTION.DOWN, 0);
        assertTrue(levelSelectMenuController.getModel().isSelectedLevel2());
        levelSelectMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(GameState.class));
    }

    @Test
    void level3SelectedTest() throws IOException {
        GameStats.setLevelsUnlocked(3);
        levelSelectMenuController.step(game, GUI.ACTION.DOWN, 0);
        levelSelectMenuController.step(game, GUI.ACTION.DOWN, 0);
        assertTrue(levelSelectMenuController.getModel().isSelectedLevel3());
        levelSelectMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(GameState.class));
    }

    @Test
    void level4SelectedTest() throws IOException {
        GameStats.setLevelsUnlocked(4);
        levelSelectMenuController.step(game, GUI.ACTION.DOWN, 0);
        levelSelectMenuController.step(game, GUI.ACTION.DOWN, 0);
        levelSelectMenuController.step(game, GUI.ACTION.DOWN, 0);
        assertTrue(levelSelectMenuController.getModel().isSelectedLevel4());
        levelSelectMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(GameState.class));
    }

    @Test
    void level5SelectedTest() throws IOException {
        GameStats.setLevelsUnlocked(5);
        levelSelectMenuController.step(game, GUI.ACTION.UP, 0);
        levelSelectMenuController.step(game, GUI.ACTION.UP, 0);
        assertTrue(levelSelectMenuController.getModel().isSelectedLevel5());
        levelSelectMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(GameState.class));
    }
    @Test
    void backSelectedTest() throws IOException {
        levelSelectMenuController.step(game, GUI.ACTION.UP,0);
        assertTrue(levelSelectMenuController.getModel().isSelectedBack());
        levelSelectMenuController.step(game, GUI.ACTION.SELECT,0);
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
}