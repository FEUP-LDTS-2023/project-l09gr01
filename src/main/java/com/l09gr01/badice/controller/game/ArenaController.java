package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.state.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final PlayerCharacterController playerCharacterController
    private final MonsterController monsterController;

    public ArenaController(Arena arena) {
        super(arena);

        this.playerCharacterController = new PlayerCharacterController(arena);
        this.monsterController = new MonsterController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}