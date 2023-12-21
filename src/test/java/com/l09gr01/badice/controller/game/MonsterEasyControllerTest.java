package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.Monster;
import com.l09gr01.badice.model.game.elements.PlayerCharacter;
import com.l09gr01.badice.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MonsterEasyControllerTest {
    private MonsterEasyController controller;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        PlayerCharacter playerCharacter = new PlayerCharacter(5, 5);
        arena.setPlayerCharacter(playerCharacter);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setFruit(Arrays.asList());
        arena.setFruitInIce(Arrays.asList());
        arena.setIceBlocks(Arrays.asList());

        controller = new MonsterEasyController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveMonsterTest() throws IOException {
        Monster monster = new Monster(5, 5, 1);
        arena.setMonsters(Arrays.asList(monster));

        controller.step(game, GUI.ACTION.NONE, 1000);

        assertNotEquals(new Position(5, 5), monster.getPosition());
    }
}
   /* @Test
   /* void moveMonstersClosed() throws IOException {
        Monster monster = new Monster(5, 5,1);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5, 6)
        ));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersGap() throws IOException {
        Monster monster = new Monster(5, 5,1);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));

        long time = 0;

        while (monster.getPosition().equals(new Position(5, 5))) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), monster.getPosition());
    }
}
*/