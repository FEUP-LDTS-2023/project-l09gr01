package com.l09gr01.badice.model.game.level;

import com.l09gr01.badice.model.game.element.Monster;
import com.l09gr01.badice.model.game.element.PlayerCharacter;
import com.l09gr01.badice.model.game.element.Wall;
import com.l09gr01.badice.model.Position;
import java.util.List;

public class Level {
    private final int width;
    private final int height;

    private PlayerCharacter playerCharacter;

    private List<Monster> monsters;
    private List<Wall> walls;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayerCharacter getHero() {
        return playerCharacter;
    }

    public void setHero(PlayerCharacter hero) {
        this.playerCharacter = hero;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
}

