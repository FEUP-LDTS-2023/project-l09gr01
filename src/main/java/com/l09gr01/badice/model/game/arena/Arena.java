package com.l09gr01.badice.model.game.arena;

import com.l09gr01.badice.gui.GameTimer;
import com.l09gr01.badice.model.Direction;
import com.l09gr01.badice.model.game.elements.*;
import com.l09gr01.badice.model.Position;

import java.util.Iterator;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private PlayerCharacter playerCharacter;
    private PlayerCharacter playerCharacter2;

    private List<Monster> monsters;
    private List<Wall> walls;

    private List<Ice> iceBlocks;
    private List<Fruit> fruits;
    private PowerUp powerUp;
    private int level;
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
    public PlayerCharacter getPlayerCharacter2() {
        return playerCharacter2;
    }

    public void setPlayerCharacter2(PlayerCharacter playerCharacter2) {
        this.playerCharacter2 = playerCharacter2;
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

    public List<Fruit> getFruit() {
        return fruits;
    }

    public void setFruit(List<Fruit> fruits) {
        this.fruits = fruits;
    }
    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public void removePowerUp(){ this.powerUp = null;}
    public boolean existsPowerUp(){ return this.powerUp != null;}

    public boolean isEmpty(Position position) { // nao seria mais facil criar aqui um isWall e um isIce?
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for(Monster monster : monsters)
        {
            if(monster.getPosition().equals(position))
                return false;
        }
        if(iceBlocks != null)
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
    public boolean isIce(Position position) {
        for (Ice ice : iceBlocks)
            if (ice.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isFruit(Position position) {
        for (Fruit fruit : fruits)
            if (fruit.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isPowerUp(Position position) {
            if (powerUp.getPosition().equals(position))
                return true;
        return false;
    }
    public void createIce(Position position){

        iceBlocks.add(new Ice(position.getX(),position.getY()));
    }
    public void destroyIce(Position position)
    {
        iceBlocks.removeIf(ice -> ice.getPosition().equals(position));
    }
    public void removeFruit(Position position){
        fruits.removeIf(fruit -> fruit.getPosition().equals(position));
    }
    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return this.level;
    }
}

