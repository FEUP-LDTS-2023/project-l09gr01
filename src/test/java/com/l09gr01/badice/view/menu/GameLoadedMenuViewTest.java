package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.GameLoadedMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameLoadedMenuViewTest {
    private GameLoadedMenu menu;
    private GameLoadedMenuView menuView;
    private InputHandler gui;

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(InputHandler.class);
        menu = new GameLoadedMenu();
        menuView = new GameLoadedMenuView(menu);
    }
    @Test
    void drawElementsTest(){
        menuView.drawElements(gui);
        Mockito.verify(gui).drawText(new Position(5,5),"PROGRESS LOADED","#FFFFFF");
        for (int i = 0; i < menu.getNumberEntries();i++){
            Mockito.verify(gui).drawText(new Position(5,7+i), menu.getEntry(i),menu.isSelected(i) ? "#FFD700" : "#FFFFFF" );
        }
    }
}
