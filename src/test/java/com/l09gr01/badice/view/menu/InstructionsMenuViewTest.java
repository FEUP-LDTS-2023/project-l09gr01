package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.InstructionsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InstructionsMenuViewTest {
    private InstructionsMenu menu;
    private InstructionsMenuView menuView;
    private InputHandler gui;

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(InputHandler.class);
        menu = new InstructionsMenu();
        menuView = new InstructionsMenuView(menu);
    }
    @Test
    void drawElementsTest(){
        menuView.drawElements(gui);
        Mockito.verify(gui).drawText(new Position(5,5),"INSTRUCTIONS","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,7),"Collect every piece of fruit ~","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,8),"as fast as possible.","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,9),"The monsters | { } will melt you","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,10),"try to avoid them!","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,11),"Press SPACEBAR to destroy","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,12),"and create ice walls &&&","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,13),"Press ARROW KEYS to move $ % ^ _","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,14),"Check for hidden fruit @","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,15),"Find powerups * to get stronger","#FFFFFF");
        for (int i = 0; i < menu.getNumberEntries();i++){
            Mockito.verify(gui).drawText(new Position(5,17+i), menu.getEntry(i),menu.isSelected(i) ? "#FFD700" : "#FFFFFF" );
        }
    }
}
