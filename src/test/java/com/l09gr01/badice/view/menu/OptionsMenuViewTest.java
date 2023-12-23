package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.OptionsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OptionsMenuViewTest {
    private OptionsMenu menu;
    private OptionsMenuView menuView;
    private InputHandler gui;

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(InputHandler.class);
        menu = new OptionsMenu();
        menuView = new OptionsMenuView(menu);
    }
    @Test
    void drawElementsTest(){
        menuView.drawElements(gui);
        Mockito.verify(gui).drawText(new Position(5,5),"OPTIONS","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,7),menu.getEntry(0) + " false",menu.isSelected(0) ? "#FFD700" : "#FFFFFF");
        for (int i = 1; i < 11;i++){
            Mockito.verify(gui).drawText(new Position(5,7+i), menu.getEntry(i),(menu.isSelected(i) && !menu.isSelectPressed(i)) ? "#FFD700" : "#FFFFFF");
            Mockito.verify(gui).drawText(new Position(23,7+i), KeybindManager.getKeyString(KeybindManager.getEditableAction(i-1)),menu.isSelectPressed(i) ? "#FFD700" : "#FFFFFF");
        }
        Mockito.verify(gui).drawText(new Position(5,19),menu.getEntry(11) + " NOT IMPLEMENTED ","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,20),menu.getEntry(12) + " NOT IMPLEMENTED ","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,22),menu.getEntry(13),"#FFFFFF");
    }
}
