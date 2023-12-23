package com.l09gr01.badice.view.menu;

import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.menu.PauseMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PauseMenuViewTest {
    private PauseMenu menu;
    private PauseMenuView menuView;
    private InputHandler gui;
    private Arena pausedArena;

    @BeforeEach
    void setUp(){
        pausedArena = Mockito.mock(Arena.class);
        gui = Mockito.mock(InputHandler.class);
        menu = new PauseMenu(pausedArena);
        menuView = new PauseMenuView(menu);
    }
    @Test
    void drawElementsTest(){
        menuView.drawElements(gui);
        Mockito.verify(gui).drawText(new Position(5,5),"GAME PAUSED","#FFFFFF");
        for (int i = 0; i < menu.getNumberEntries();i++){
            Mockito.verify(gui).drawText(new Position(5,7+i), menu.getEntry(i),menu.isSelected(i) ? "#FFD700" : "#FFFFFF" );
        }
    }
}
