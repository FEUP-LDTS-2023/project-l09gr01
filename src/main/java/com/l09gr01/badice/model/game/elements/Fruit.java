package com.l09gr01.badice.model.game.elements;

public class Fruit extends Element {

    private String type;
    public Fruit(int x, int y) {
        super(x, y);
    }

    public String getFruitType(){
        return this.type;
    };
    public void setFruitType(String type) {
        this.type = type;
    };
}
