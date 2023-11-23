package com.l09gr01.badice.model.elements;

public class SpeedPowerUp extends PowerUp
{
    public SpeedPowerUp(int x, int y)
    {
        super(x,y);
    }

    public void SpeedIncrease(PlayerCharacter playerCharacter)
    {
        playerCharacter.increaseHp();
    }

}
