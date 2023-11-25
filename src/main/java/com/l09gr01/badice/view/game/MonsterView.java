package com.l09gr01.badice.view.game;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.model.game.elements.Monster;

public class MonsterView implements ElementView<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}