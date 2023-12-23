package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.MainMenu;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainMenuViewTest {
    private MainMenu menu;
    private MainMenuView menuView;
    private InputHandler gui;

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(InputHandler.class);
        menu = new MainMenu();
        menuView = new MainMenuView(menu);
    }
    @Test
    void drawElementsTest(){
        menuView.drawElements(gui);
        Mockito.verify(gui).drawText(new Position(5,5),"BAD ICE","#FFFFFF");
        for (int i = 0; i < menu.getNumberEntries();i++){
            Mockito.verify(gui).drawText(new Position(5,7+i), menu.getEntry(i),menu.isSelected(i) ? "#FFD700" : "#FFFFFF" );
        }
    }

}
