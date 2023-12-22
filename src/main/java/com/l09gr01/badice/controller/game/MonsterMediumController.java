package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.Monster;

import java.io.IOException;

public class MonsterMediumController extends GameController {
    private long lastMovement;

    public MonsterMediumController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (time - lastMovement >= 300) {
            for (Monster monster : getModel().getMonsters())
                if(monster.getDifficulty() == 2) moveMonster(monster, monster.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }
    }


    private void moveMonster(Monster monster, Position position) {
        if (getModel().isEmpty(position) || getModel().isPlayerCharacter(position)) {
            monster.setPosition(position);
            if (getModel().getPlayerCharacter().getPosition().equals(position))
            {
                getModel().getPlayerCharacter().decreaseHp();
            }
            if (getModel().existsP2() && getModel().getPlayer2Character().getPosition().equals(position))
            {
                getModel().getPlayer2Character().decreaseHp();
            }
        }
    }
    }

