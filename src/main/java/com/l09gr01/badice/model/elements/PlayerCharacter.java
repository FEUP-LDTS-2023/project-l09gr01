package com.l09gr01.badice.model.elements;

import java.util.List;

public class PlayerCharacter extends  Element {

    private int hp;
    private String lastmovement;
    private List<PowerUp> powerUps; // o unico power up que o char pode ter vai ser uma bomba mas esta para ser implementado maos no futuro

    public PlayerCharacter(int x, int y)
    {
        super(x,y);
        this.hp = 1;
        this.lastmovement = "Up";
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

    public String getLastmovement()
    {
        return this.lastmovement;
    }

    public void setLastmovement(String lastmovement)
    {
        this.lastmovement = lastmovement; // no controler e que se4 poe quel e que e a string que aqui fica
    }

    public void addPowerUp(PowerUp powerUp)
    {
        powerUps.add(powerUp);
    }

    public PowerUp getPowerUp()
    {
        return powerUps.get(0);
    }
}
