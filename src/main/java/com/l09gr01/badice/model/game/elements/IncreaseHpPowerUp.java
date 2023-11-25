package com.l09gr01.badice.model.game.elements;

import com.l09gr01.badice.model.elements.PlayerCharacter;
import com.l09gr01.badice.model.elements.PowerUp;

public class IncreaseHpPowerUp extends PowerUp
{
    public IncreaseHpPowerUp(int x, int y)
    {
        super(x,y);
    }

    public void SpeedIncrease(PlayerCharacter playerCharacter)
    {
        playerCharacter.increaseHp();
    }

}
