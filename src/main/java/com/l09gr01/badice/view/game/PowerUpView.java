package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.PowerUp;

public class PowerUpView implements ElementView<PowerUp> {
    @Override
    public void draw(PowerUp powerUp, GUI gui) {
        gui.drawPowerUp(powerUp.getPosition());
    }
}
