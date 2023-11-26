package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.Monster;

import java.io.IOException;

public class MonsterHardController extends GameController implements MonsterController {
    private long lastMovement;

    public MonsterHardController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        /*
        hard algorithm here
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters())
                moveMonster(monster, monster.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }*/
    }

    private void moveMonster(Monster monster, Position position) {
        // hard algorithm here
    }
}
