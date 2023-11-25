package com.l09gr01.badice.model.elements;

public class Monster extends Element {

    private int difficulty;

    public Monster(int x, int y)
    {
        super(x,y);
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