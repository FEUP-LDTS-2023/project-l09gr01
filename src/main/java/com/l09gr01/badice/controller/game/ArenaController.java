package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.menu.LevelSelectMenu;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.model.menu.PauseMenu;
import com.l09gr01.badice.state.LevelSelectMenuState;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.state.PauseMenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final PlayerCharacterController playerCharacterController;
    private final MonsterEasyController monsterEasyController;
    private final MonsterMediumController monsterMediumController;
    private final MonsterHardController monsterHardController;

    public ArenaController(Arena arena) {
        super(arena);

        this.playerCharacterController = new PlayerCharacterController(arena);
        this.monsterEasyController = new MonsterEasyController(arena);
        this.monsterMediumController = new MonsterMediumController(arena);
        this.monsterHardController = new MonsterHardController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || action == GUI.ACTION.PAUSE)
            game.setState(new PauseMenuState(new PauseMenu()));
        else if (getModel().getFruit().isEmpty()){
            if (getModel().getLevel() == game.getLevelUnlocks()) game.setLevelUnlocks(game.getLevelUnlocks() + 1);
            game.setState(new LevelSelectMenuState(new LevelSelectMenu()));
        }
        else if(getModel().getPlayerCharacter().getHp() == 0)
        {
            game.setState(new MainMenuState(new MainMenu()));
        }
        else {
            playerCharacterController.step(game, action, time);
            monsterEasyController.step(game, action, time);
            monsterMediumController.step(game,action,time);
            monsterHardController.step(game,action,time);
        }
    }
}