package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.LevelSelectMenu;
import com.l09gr01.badice.utils.GameStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LevelSelectMenuViewTest {
    private LevelSelectMenu menu;
    private LevelSelectMenuView menuView;
    private InputHandler gui;

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(InputHandler.class);
        menu = new LevelSelectMenu();
        menuView = new LevelSelectMenuView(menu);
        GameStats.setLevelsUnlocked(2);
        GameStats.setLevelTimer(1,"00:35");
        GameStats.setLevelTimer(2,null);
    }
    @Test
    void drawElementsTest(){
        menuView.drawElements(gui);
        Mockito.verify(gui).drawText(new Position(5,5),"SELECT LEVEL","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,7), menu.getEntry(0) + " BEST TIME: 00:35",menu.isSelected(0) ? "#FFD700" : "#FFFFFF" );
        Mockito.verify(gui).drawText(new Position(5,8), menu.getEntry(1) + " NOT COMPLETED",menu.isSelected(1) ? "#FFD700" : "#FFFFFF" );
        Mockito.verify(gui).drawText(new Position(5,9), menu.getEntry(2) + " LOCKED",menu.isSelected(2) ? "#FFD700" : "#FFFFFF" );
        Mockito.verify(gui).drawText(new Position(5,10), menu.getEntry(3) + " LOCKED",menu.isSelected(3) ? "#FFD700" : "#FFFFFF" );
        Mockito.verify(gui).drawText(new Position(5,11), menu.getEntry(4) + " LOCKED",menu.isSelected(4) ? "#FFD700" : "#FFFFFF" );
        Mockito.verify(gui).drawText(new Position(5,14), menu.getEntry(5), menu.isSelected(5) ? "#FFD700" : "#FFFFFF" );
    }
}

