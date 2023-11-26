package com.l09gr01.badice.model.game.arena;

import com.l09gr01.badice.model.game.elements.Ice;
import com.l09gr01.badice.model.game.elements.Monster;
import com.l09gr01.badice.model.game.elements.PlayerCharacter;
import com.l09gr01.badice.model.game.elements.Wall;
import com.l09gr01.badice.model.Position;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private PlayerCharacter playerCharacter;

    private List<Monster> monsters;
    private List<Wall> walls;

    private List<Ice> iceBlocks;




    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
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


    public List<Ice> getIceBlocks() {
        return iceBlocks;
    }

    public void setIceBlocks(List<Ice> iceBlocks) {
        this.iceBlocks = iceBlocks;
    }



    public boolean isEmpty(Position position) { // nao seria mais facil criar aqui um isWall e um isIce?
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;

        for(Ice ice : iceBlocks)
            if(ice.getPosition().equals(position))
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

