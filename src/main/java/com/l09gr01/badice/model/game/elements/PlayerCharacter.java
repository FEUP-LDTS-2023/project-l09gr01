package com.l09gr01.badice.model.game.elements;

public class PlayerCharacter extends Element {
    private int energy;

    public PlayerCharacter(int x, int y) {
        super(x, y);
        this.energy = 10;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public int getEnergy() {
        return energy;
    }
}