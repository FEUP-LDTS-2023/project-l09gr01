package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.menu.HiscoresMenu;
import com.l09gr01.badice.utils.HiscoreEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;

public class HiscoresMenuViewTest {
    private HiscoresMenu menu;
    private HiscoresMenuView menuView;
    private InputHandler gui;

    @BeforeEach
    void setUp(){
        gui = Mockito.mock(InputHandler.class);
        menu = Mockito.mock(HiscoresMenu.class);
        menuView = new HiscoresMenuView(menu);
        Mockito.when(menu.getHiscores()).thenReturn(Arrays.asList(new HiscoreEntry(1,"JOAO",5000,"05:00"),
                new HiscoreEntry(2,"RACHEL",4000,"03:50")));
        Mockito.when(menu.getEntry(0)).thenReturn("OK");
    }
    @Test
    void drawElementsTest(){
        menuView.drawElements(gui);
        Mockito.verify(gui).drawText(new Position(5,5),"HISCORES","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(8,7),"NAME","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(20,7),"SCORE","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(30,7),"TIME","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,9),"1.","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(8,9),"JOAO","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(18,9),"- 5000","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(27,9),"- 05:00","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,10),"2.","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(8,10),"RACHEL","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(18,10),"- 4000","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(27,10),"- 03:50","#FFFFFF");
        Mockito.verify(gui).drawText(new Position(5,21),"OK","#FFD700");
    }
}
