package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.*;
import com.l09gr01.badice.model.menu.LevelCompletedMenu;
import com.l09gr01.badice.state.GameOverMenuState;
import com.l09gr01.badice.state.LevelCompletedMenuState;
import com.l09gr01.badice.state.LevelSelectMenuState;
import com.l09gr01.badice.state.PauseMenuState;
import com.l09gr01.badice.utils.GameStats;
import com.l09gr01.badice.utils.HiscoresManager;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class ArenaControllerTest {
    private Game game;
    private Arena arena;
    private PlayerCharacter player;
    private PlayerCharacter player2;
    private ArenaController arenaController;
    private PowerUp powerUp;
    private List<Ice> iceBlocks;
    private List<Fruit> fruits;
    private List<FruitInIce> fruitsInIce;

    @BeforeEach
    void setUp(){
        game = Mockito.mock(Game.class);
        arena = new Arena(20,20);
        arenaController = new ArenaController(arena);
        arenaController.setPlayerCharacterController(Mockito.mock(PlayerCharacterController.class));
        arenaController.setPlayer2CharacterController(Mockito.mock(Player2CharacterController.class));
        arenaController.setMonsterEasyController(Mockito.mock(MonsterEasyController.class));
        arenaController.setMonsterMediumController(Mockito.mock(MonsterMediumController.class));
        arenaController.setMonsterHardController(Mockito.mock(MonsterHardController.class));
        player = new PlayerCharacter(5, 5);
        player2 = new PlayerCharacter(6,6);
        iceBlocks = new ArrayList<>();
        fruits = new ArrayList<>();
        fruits.add(new Fruit(2,2));
        fruitsInIce = new ArrayList<>();
        powerUp = new PowerUp(5,4);
        arena.setWalls(Arrays.asList());
        arena.setPlayerCharacter(player);
        arena.setPlayer2Character(player2);
        arena.setMonsters(Arrays.asList());
        arena.setFruit(fruits);
        arena.setFruitInIce(fruitsInIce);
        arena.setIceBlocks(iceBlocks);
        arena.setPowerUp(powerUp);
        arena.setLevel(1);
    }

    @Test
    void pauseTest() throws IOException {
        arenaController.step(game, GUI.ACTION.NONE,0);
        assertFalse(arena.getGameTimer().isPaused);
        arenaController.step(game, GUI.ACTION.PAUSE,0);
        assertTrue(arena.getGameTimer().isPaused);
        assertFalse(KeybindManager.isIngame());
        verify(game).setState(Mockito.any(PauseMenuState.class));
    }
    @Test
    void allFruitPickedUp() throws IOException {
        arena.removeFruit(new Position(2,2));
        arenaController.step(game, GUI.ACTION.NONE,0);
        assertTrue(arena.getGameTimer().isPaused);
        verify(game).setState(Mockito.any(LevelCompletedMenuState.class));
    }
    @Test
    void playerLostTest() throws IOException {
        arena.getPlayerCharacter().setHp(0);
        arenaController.step(game, GUI.ACTION.NONE,0);
        assertTrue(arena.getGameTimer().isPaused);
        assertTrue(HiscoresManager.wasGamePlayed());
        verify(game).setState(Mockito.any(GameOverMenuState.class));
    }
    @Test
    void powerUpSpawnTest() throws IOException {
        while(!arena.existsPowerUp()) arenaController.step(game, GUI.ACTION.NONE,0);
        assertTrue(arena.existsPowerUp());
    }

}
