package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.game.elements.Monster;

public class MonsterView implements ElementView<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        switch (monster.getDifficulty()) {
            case (1):
                gui.drawEasyMonster(monster.getPosition());
                break;
            case (2):
                gui.drawMediumMonster(monster.getPosition());
                break;
            case (3):
                gui.drawHardMonster(monster.getPosition());
                break;
            default:
                break;
        }
    }
}