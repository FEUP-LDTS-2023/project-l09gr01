package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.state.*;
import com.l09gr01.badice.utils.GameStats;
import com.l09gr01.badice.utils.LoadGameStats;
import com.l09gr01.badice.utils.SaveGameStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private Game game;

    @BeforeEach
    void setUp() {
        MainMenu mainMenu = new MainMenu();
        mainMenuController = new MainMenuController(mainMenu);
        game = Mockito.mock(Game.class);
    }
    @Test
    void newGameSelectedTest() throws IOException {
        try (MockedStatic<GameStats> mockedGameStats = Mockito.mockStatic(GameStats.class)) {
            assertTrue(mainMenuController.getModel().isSelectedNew());
            mainMenuController.step(game, GUI.ACTION.SELECT, 0);
            mockedGameStats.verify(GameStats::resetGame);
            verify(game).setState(Mockito.any(GameState.class));
        }
    }
    @Test
    void chooseLevelTest() throws IOException {
        mainMenuController.step(game, GUI.ACTION.DOWN, 0);
        assertTrue(mainMenuController.getModel().isSelectedChooseLevel());
        mainMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(LevelSelectMenuState.class));
    }
    @Test
    void loadGameSelectedTest() throws IOException {
        try (MockedStatic<LoadGameStats> mockedLoadGameStats = Mockito.mockStatic(LoadGameStats.class)) {
            mainMenuController.step(game, GUI.ACTION.DOWN, 0);
            mainMenuController.step(game, GUI.ACTION.DOWN, 0);
            assertTrue(mainMenuController.getModel().isSelectedLoad());
            mainMenuController.step(game, GUI.ACTION.SELECT, 0);
            mockedLoadGameStats.verify(() -> LoadGameStats.loadGameStats("data/saveFile.txt"));
            verify(game).setState(Mockito.any(GameLoadedMenuState.class));
        }
    }
    @Test
    void instructionsSelectedTest() throws IOException {
        mainMenuController.step(game, GUI.ACTION.DOWN, 0);
        mainMenuController.step(game, GUI.ACTION.DOWN, 0);
        mainMenuController.step(game, GUI.ACTION.DOWN, 0);
        assertTrue(mainMenuController.getModel().isSelectedInstructions());
        mainMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(InstructionsMenuState.class));
    }
    @Test
    void hiscoresSelectedTest() throws IOException {
        mainMenuController.step(game, GUI.ACTION.DOWN, 0);
        mainMenuController.step(game, GUI.ACTION.DOWN, 0);
        mainMenuController.step(game, GUI.ACTION.DOWN, 0);
        mainMenuController.step(game, GUI.ACTION.DOWN, 0);
        assertTrue(mainMenuController.getModel().isSelectedHiscores());
        mainMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(HiscoresMenuState.class));
    }
    @Test
    void optionsSelectedTest() throws IOException {
        mainMenuController.step(game, GUI.ACTION.UP, 0);
        mainMenuController.step(game, GUI.ACTION.UP, 0);
        mainMenuController.step(game, GUI.ACTION.UP, 0);
        assertTrue(mainMenuController.getModel().isSelectedOptions());
        mainMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(Mockito.any(OptionsMenuState.class));
    }

    @Test
    void saveSelectedTest() throws IOException {
        try (MockedStatic<SaveGameStats> mockedSaveGameStats = Mockito.mockStatic(SaveGameStats.class)){
            GameStats.setLevelsUnlocked(1);
            mainMenuController.step(game, GUI.ACTION.UP, 0);
            mainMenuController.step(game, GUI.ACTION.UP, 0);
            assertTrue(mainMenuController.getModel().isSelectedSave());
            mainMenuController.step(game, GUI.ACTION.SELECT, 0);
            mockedSaveGameStats.verify(() -> SaveGameStats.saveGameStats(1,"data/saveFile.txt"));
            verify(game).setState(Mockito.any(GameSavedMenuState.class));
        }
    }
    @Test
    void exitSelectedTest() throws IOException {
        mainMenuController.step(game, GUI.ACTION.UP, 0);
        assertTrue(mainMenuController.getModel().isSelectedExit());
        mainMenuController.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(ArgumentMatchers.isNull());
    }
}

