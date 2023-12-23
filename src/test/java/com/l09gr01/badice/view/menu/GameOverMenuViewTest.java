package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.GameOverMenu;
import com.l09gr01.badice.utils.GameStats;
import com.l09gr01.badice.utils.LoadGameStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class GameOverMenuViewTest {
    private GameOverMenu menu;
    private GameOverMenuView menuView;
    private InputHandler gui;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(InputHandler.class);
        menu = new GameOverMenu(1, "00:50", 500);
        menuView = new GameOverMenuView(menu);
    }

    @Test
    void drawElementsTest() {
        GameStats.resetGame();
        menuView.drawElements(gui);
        //Mockito.verify(gui).drawText(new Position(5, 5), "} LEVEL 1 FAILED! }", "#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5, 7), "TIME: 00:50", "#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5, 8), "SCORE: 500", "#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5, 10), "TOTAL SCORE: 0", "#FFFFFF");
        for (int i = 0; i < menu.getNumberEntries(); i++) {
            Mockito.verify(gui).drawText(new Position(5, 12 + i), menu.getEntry(i), menu.isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}

