package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.LevelCompletedMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LevelCompletedMenuViewTest {
    private LevelCompletedMenu menu;
    private LevelCompletedMenuView menuView;
    private InputHandler gui;

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(InputHandler.class);
        menu = new LevelCompletedMenu(1,"02:01",1000);
        menuView = new LevelCompletedMenuView(menu);
    }
    @Test
    void drawElementsTest(){
        menuView.drawElements(gui);
        Mockito.verify(gui).drawText(new Position(5,6),"LEVEL 1 COMPLETE!","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,7),"TIME: 02:01","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,8),"SCORE: 1000","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,10),"TOTAL SCORE: 0","#FFFFFF");
        for (int i = 0; i < menu.getNumberEntries();i++){
            Mockito.verify(gui).drawText(new Position(5,12+i), menu.getEntry(i),menu.isSelected(i) ? "#FFD700" : "#FFFFFF" );
        }
    }
}
