package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.NewHiscoreMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NewHiscoreMenuViewTest {
    private NewHiscoreMenu menu;
    private NewHiscoreMenuView menuView;
    private InputHandler gui;

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(InputHandler.class);
        menu = new NewHiscoreMenu(3,11000,"10:01");
        menuView = new NewHiscoreMenuView(menu);
    }
    @Test
    void drawElementsTest(){
        menuView.drawElements(gui);
        Mockito.verify(gui).drawText(new Position(5,5),"NEW HISCORE! ENTER YOUR NAME:","#FFFFFF");
        for (int i = 0; i < menu.getNumberEntries();i++){
            Mockito.verify(gui).drawText(new Position(5,7+i), menu.getEntry(i),menu.isSelected(i) ? "#FFD700" : "#FFFFFF" );
        }
    }
}
