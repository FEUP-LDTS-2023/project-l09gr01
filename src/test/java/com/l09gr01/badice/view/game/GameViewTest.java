package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.*;
import com.l09gr01.badice.view.game.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class GameViewTest {
    private GUI gui;
    private GameView viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameView(arena);

        arena.setWalls(Arrays.asList(new Wall(1, 2), new Wall(2, 3), new Wall(3, 4)));
        arena.setMonsters(Arrays.asList(new Monster(4, 5,1), new Monster(5, 6,2)));
        arena.setPlayerCharacter(new PlayerCharacter(5, 8));
        arena.setFruit(Arrays.asList(new Fruit(9,9), new Fruit(8,8)));
        arena.setIceBlocks(Arrays.asList(new Ice(3,2), new Ice(3,3)));
        arena.setFruitInIce(Arrays.asList(new FruitInIce(3,9), new FruitInIce(3,8)));
    }


    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawMonsters() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEasyMonster(new Position(4, 5));
        Mockito.verify(gui, Mockito.times(1)).drawMediumMonster(new Position(5, 6));
    }

    @Test
    void drawUpPlayerCharacter() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawUpPlayerCharacter(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawUpPlayerCharacter(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
