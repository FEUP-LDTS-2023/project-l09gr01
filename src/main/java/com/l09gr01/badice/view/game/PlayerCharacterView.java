package com.l09gr01.badice.view.game;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.model.game.elements.PlayerCharacter;

public class PlayerCharacterView implements ElementView<PlayerCharacter> {
    @Override
    public void draw(PlayerCharacter playerCharacter, GUI gui) {
        gui.drawPlayerCharacter(playerCharacter.getPosition());
    }
}