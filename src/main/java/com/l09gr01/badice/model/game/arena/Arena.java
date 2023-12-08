package com.l09gr01.badice.model.game.arena;

<<<<<<< Updated upstream
import com.l09gr01.badice.model.game.elements.Monster;
import com.l09gr01.badice.model.game.elements.PlayerCharacter;
import com.l09gr01.badice.model.game.elements.Wall;
import com.l09gr01.badice.model.Position;
=======
import com.l09gr01.badice.gui.GameTimer;
import com.l09gr01.badice.model.game.elements.*;
import com.l09gr01.badice.model.Position;

>>>>>>> Stashed changes
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private PlayerCharacter playerCharacter;

    private List<Monster> monsters;
    private List<Wall> walls;

<<<<<<< Updated upstream
=======
    private List<Ice> iceBlocks;
    private List<Fruit> fruits;
    private PowerUp powerUp;
    private int level;
    private List<FruitInIce> fruitsInIce;
    private final GameTimer gameTimer = new GameTimer();
>>>>>>> Stashed changes
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        gameTimer.start();
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
<<<<<<< Updated upstream
=======
    public boolean isIce(Position position) {
        for (Ice ice : iceBlocks)
            if (ice.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isFruitInIce(Position position){
        for (FruitInIce fruitInIce : fruitsInIce)
            if (fruitInIce.getPosition().equals(position))
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
        if (isFruit(position)) fruitsInIce.add(new FruitInIce(position.getX(), position.getY()));
    }
    public void destroyIce(Position position)
    {
        fruitsInIce.removeIf(fruitInIce -> fruitInIce.getPosition().equals(position));
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

    public GameTimer getGameTimer() {
        return gameTimer;
    }
    public void pauseGameTimer(){
    gameTimer.pause();
    }
    public void resumeGameTimer(){
        gameTimer.resume();
    }
    public ArenaData getArenaData() {
        return new ArenaData(this);
    }
    public Arena getArena(){
        return this;
    }
>>>>>>> Stashed changes
}

