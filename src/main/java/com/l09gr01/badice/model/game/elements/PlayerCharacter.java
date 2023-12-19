package com.l09gr01.badice.model.game.elements;



import com.l09gr01.badice.model.Direction;

import static com.l09gr01.badice.model.Direction.UP;

public class PlayerCharacter extends Element {

    private int hp;
    private Direction facingDirection;
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

}