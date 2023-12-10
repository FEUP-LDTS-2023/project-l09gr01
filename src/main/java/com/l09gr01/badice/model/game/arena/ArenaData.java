package com.l09gr01.badice.model.game.arena;

import com.l09gr01.badice.gui.GameTimer;
import com.l09gr01.badice.model.game.elements.*;

import java.io.Serializable;
import java.util.List;

public class ArenaData implements Serializable {
    private int width;
    private int height;
    private PlayerCharacter playerCharacter;
    private PlayerCharacter playerCharacter2;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<Ice> iceBlocks;
    private List<Fruit> fruits;
    private PowerUp powerUp;
    private int level;
    private List<FruitInIce> fruitsInIce;
    private GameTimer gameTimer;
    // Add other necessary fields...

    public ArenaData(Arena arena) {
        // Populate fields from the Arena instance
        this.width = arena.getWidth();
        this.height = arena.getHeight();
        this.playerCharacter = arena.getPlayerCharacter();
        this.playerCharacter2 = arena.getPlayerCharacter2();
        this.monsters = arena.getMonsters();
        this.walls = arena.getWalls();
        this.iceBlocks = arena.getIceBlocks();
        this.fruits = arena.getFruit();
        this.powerUp = arena.getPowerUp();
        this.level = arena.getLevel();
        this.fruitsInIce = arena.getFruitInIce();
        this.gameTimer = arena.getGameTimer();
        // Set other fields...
    }

    // Add getters for the fields...
}
