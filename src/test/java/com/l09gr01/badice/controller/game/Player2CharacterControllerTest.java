package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.model.Direction;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.PlayerCharacter;
import com.l09gr01.badice.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Player2CharacterControllerTest {
    private Player2CharacterController controller;
    private PlayerCharacter player2;

    private Arena arena;

    @BeforeEach
    void setUp()
    {
        arena = new Arena(10,10);
        player2 = new PlayerCharacter(5,5);
        PlayerCharacter player = new PlayerCharacter(1,1);
        arena.setPlayer2Character(player2);
        arena.setPlayerCharacter(player);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setFruit(Arrays.asList());
        arena.setFruitInIce(Arrays.asList());
        arena.setIceBlocks(Arrays.asList());

        controller = new Player2CharacterController(arena);
    }

    @Test
    void movePlayerRightWithoutWall()
    {
        player2.setDirection(Direction.RIGHT);
        controller.movePlayer2CharacterRight();
        assertEquals(new Position(6,5), player2.getPosition());
    }

    @Test
    void movePlayerRightWithWall()
    {
        arena.setWalls(Arrays.asList(new Wall(6,5)));
        controller.movePlayer2CharacterRight();

        assertEquals(new Position(5,5), player2.getPosition());
    }
}
