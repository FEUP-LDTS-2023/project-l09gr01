package com.l09gr01.badice.model.game.elements;



import com.l09gr01.badice.model.Direction;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.view.game.observers.ScoreObserver;

import java.util.List;

import static com.l09gr01.badice.model.Direction.UP;

public class PlayerCharacter extends Element {

    private int hp;
    private Direction facingDirection;
    private List<PowerUp> powerUps;// o unico power up que o char pode ter vai ser uma bomba mas esta para ser implementado maos no futuro
    private int score = 0;
    private List<ScoreObserver> observers;
    private int playerNumber;
    public PlayerCharacter(int x, int y)
    {
        super(x,y);
        this.hp = 1;
        this.facingDirection = UP;
    }

    public int getHp()
    {
        return this.hp;
    }

    public void decreaseHp()
    {
        this.hp--;
    }

    public void increaseHp()
    {
        this.hp++;
    }

    public Direction getDirection()
    {
        return this.facingDirection;
    }

    public void setDirection(Direction facingDirection)
    {
        this.facingDirection = facingDirection;
    }

    public void addPowerUp(PowerUp powerUp)
    {
        powerUps.add(powerUp);
    }

    public PowerUp getPowerUp()
    {
        return powerUps.get(0);
    }
    public Position getFront() {
        return this.getPosition(); // + facingDirection
    }
    public void pickUpFruit(Fruit fruit){
        this.score += 10;
    }
    public void setScore(int newScore){
        this.score = newScore;
    }
    public int getScore(){
        return this.score;
    }

}