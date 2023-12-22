package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.Fruit;
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

public class MonsterHardControllerTest {
    private MonsterHardController controller;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        PlayerCharacter playerCharacter = new PlayerCharacter(9, 9);
        arena.setPlayerCharacter(playerCharacter);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setFruit(Arrays.asList(new Fruit(2,2)));
        arena.setFruitInIce(Arrays.asList());
        arena.setIceBlocks(Arrays.asList());

        controller = new MonsterHardController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveMonsterTest() throws IOException {
        Monster monster = new Monster(5, 5, 3);
        arena.setMonsters(Arrays.asList(monster));

        controller.step(game, GUI.ACTION.NONE, 500);

        assertNotEquals(new Position(5, 5), monster.getPosition());
    }
    @Test
    void moveMonstersClosed() throws IOException {
        Monster monster = new Monster(5, 5,2);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5, 6)
        ));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 500);

        assertEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersGap() throws IOException {
        Monster monster = new Monster(5, 5,3);
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


    @Test
    void monsterHitPlayerTest() throws IOException {
        Monster monster1 = new Monster(1, 1,3);
        Monster monster2 = new Monster(9,9,3);
        arena.getPlayerCharacter().setPosition(new Position(4,4));
        PlayerCharacter player2Character = new PlayerCharacter(6,6);
        arena.setPlayer2Character(player2Character);
        player2Character.setHp(100);
        arena.getPlayerCharacter().setHp(100);
        arena.setMonsters(Arrays.asList(monster1, monster2));
        long time = 0;
        while (arena.getPlayerCharacter().getHp() == 100 || arena.getPlayer2Character().getHp() == 100) {
            time += 100;
            controller.step(game, GUI.ACTION.NONE, time);
        }
        assertNotEquals(arena.getPlayerCharacter().getHp(), 100);
        assertNotEquals(arena.getPlayer2Character().getHp(), 100);

    }
}
