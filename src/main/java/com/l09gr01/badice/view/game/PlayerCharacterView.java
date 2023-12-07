package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.PlayerCharacter;

public class PlayerCharacterView implements ElementView<PlayerCharacter> {
    @Override
    public void draw(PlayerCharacter playerCharacter, GUI gui) {
        switch (playerCharacter.getDirection()) {
            case UP -> gui.drawUpPlayerCharacter(playerCharacter.getPosition());
            case DOWN -> gui.drawDownPlayerCharacter(playerCharacter.getPosition());
            case LEFT -> gui.drawLeftPlayerCharacter(playerCharacter.getPosition());
            case RIGHT -> gui.drawRightPlayerCharacter(playerCharacter.getPosition());

        }
    }
}