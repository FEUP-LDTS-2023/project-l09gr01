package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.controller.game.PlayerCharacterController;
import com.l09gr01.badice.model.Direction;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.PlayerCharacter;
import com.l09gr01.badice.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class PlayerCharacterControllerTest {

    private PlayerCharacterController controller;
    private PlayerCharacter player;

    private Arena arena;

    @BeforeEach
    void setUp()
    {
        arena = new Arena(10,10);
        player = new PlayerCharacter(5,5);
        arena.setPlayerCharacter(player);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setFruit(Arrays.asList());
        arena.setFruitInIce(Arrays.asList());
        arena.setIceBlocks(Arrays.asList());

        controller = new PlayerCharacterController(arena);
    }

    @Test
    void movePlayerRightWithoutWall()
    {
        player.setDirection(Direction.RIGHT);
        controller.movePlayerCharacterRight();
        assertEquals(new Position(6,5), player.getPosition());
    }

    @Test
    void movePlayerRightWithWall()
    {
        arena.setWalls(Arrays.asList(new Wall(6,5)));
        controller.movePlayerCharacterRight();

        assertEquals(new Position(5,5), player.getPosition());
    }

}
