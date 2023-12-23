package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterViewTest {
    private Monster monster1;
    private Monster monster2;
    private Monster monster3;
    private MonsterView view;
    private GUI gui;

    @BeforeEach
    void setUp(){
        monster1 = new Monster(10,10,1);
        monster2 = new Monster(10, 5, 2);
        monster3 = new Monster(5, 10, 3);
        view = new MonsterView();
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawEasyMonster(){
        view.draw(monster1, gui);
        Mockito.verify(gui, Mockito.times(1)).drawEasyMonster(monster1.getPosition());
    }
    @Test
    void drawMediumMonster(){
        view.draw(monster2, gui);
        Mockito.verify(gui, Mockito.times(1)).drawMediumMonster(monster2.getPosition());
    }
    @Test
    void drawHardMonster(){
        view.draw(monster3, gui);
        Mockito.verify(gui, Mockito.times(1)).drawHardMonster(monster3.getPosition());
    }
}
