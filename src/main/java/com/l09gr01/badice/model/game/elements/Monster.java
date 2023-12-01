package com.l09gr01.badice.model.game.elements;

public class Monster extends Element {

    private int difficulty;

    public Monster(int x, int y, int difficulty)
    {
        super(x,y);
        this.difficulty = difficulty;
    }

    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    public int getDifficulty()
    {
        return this.difficulty;
    }
}