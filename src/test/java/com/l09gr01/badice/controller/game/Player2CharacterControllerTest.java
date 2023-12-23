package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.Direction;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Player2CharacterControllerTest {
    private Game game;
    private Player2CharacterController controller;
    private PlayerCharacter player2;
    private PowerUp powerUp;
    private List<Ice> iceBlocks;
    private List<Fruit> fruits;
    private List<FruitInIce> fruitsInIce;

    private Arena arena;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        arena = new Arena(10, 10);
        player2 = new PlayerCharacter(5, 5);
        PlayerCharacter player = new PlayerCharacter(1, 1);
        arena.setPlayer2Character(player2);
        arena.setPlayerCharacter(player);

        iceBlocks = new ArrayList<>();
        fruits = new ArrayList<>();
        fruitsInIce = new ArrayList<>();
        powerUp = new PowerUp(5,4);
        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setFruit(fruits);
        arena.setFruitInIce(fruitsInIce);
        arena.setIceBlocks(iceBlocks);
        arena.setPowerUp(powerUp);

        controller = new Player2CharacterController(arena);
    }

    @Test
    void movePlayerRightWithoutWall() {
        controller.step(game, GUI.ACTION.P2RIGHT,0);
        controller.step(game, GUI.ACTION.P2RIGHT,0);
        assertEquals(new Position(6, 5), player2.getPosition());
    }

    @Test
    void movePlayerRightWithWall() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.step(game, GUI.ACTION.P2RIGHT,0);
        controller.step(game, GUI.ACTION.P2RIGHT,0);
        assertEquals(new Position(5, 5), player2.getPosition());
    }
    @Test
    void destroyAndCreateIce() {
        arena.setWalls(Arrays.asList(new Wall(5, 3)));
        iceBlocks.add(new Ice(4, 5));
        controller.step(game, GUI.ACTION.P2ACTION, 0);
        controller.step(game, GUI.ACTION.P2LEFT, 0);
        controller.step(game, GUI.ACTION.P2ACTION, 0);
        assertFalse(arena.isIce(new Position(4, 5)));
        assertTrue(arena.isIce(new Position(5, 4)));
    }
    @Test
    void moveAndPickUpTest(){
        fruits.add(new Fruit(4,5));
        fruits.add(new Fruit(3,5));
        fruits.add(new Fruit(2,5));
        fruits.add(new Fruit(2,6));
        fruits.add(new Fruit(2,7));
        fruits.add(new Fruit(2,8));
        iceBlocks.add(new Ice(2,6));
        iceBlocks.add(new Ice(2,7));
        iceBlocks.add(new Ice(2,8));
        fruitsInIce.add(new FruitInIce(2,6));
        fruitsInIce.add(new FruitInIce(2,7));
        fruitsInIce.add(new FruitInIce(2,8));
        controller.step(game, GUI.ACTION.P2UP,0);
        controller.step(game, GUI.ACTION.P2DOWN,0);
        controller.step(game, GUI.ACTION.P2DOWN,0);
        controller.step(game, GUI.ACTION.P2LEFT,0);
        controller.step(game, GUI.ACTION.P2LEFT,0);
        controller.step(game, GUI.ACTION.P2LEFT,0);
        controller.step(game, GUI.ACTION.P2LEFT,0);
        controller.step(game, GUI.ACTION.P2DOWN,0);
        controller.step(game, GUI.ACTION.P2ACTION,0);
        controller.step(game, GUI.ACTION.P2DOWN,0);
        controller.step(game, GUI.ACTION.P2DOWN,0);
        controller.step(game, GUI.ACTION.P2DOWN,0);
        assertEquals(player2.getHp(),2);
        assertTrue(fruits.isEmpty());
        assertTrue(fruitsInIce.isEmpty());
        assertTrue(iceBlocks.isEmpty());
    }
}
