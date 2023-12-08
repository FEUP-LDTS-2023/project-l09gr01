package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.game.arena.Arena;
<<<<<<< Updated upstream
import com.l09gr01.badice.state.MenuState;
=======
import com.l09gr01.badice.model.menu.*;
import com.l09gr01.badice.state.*;
import com.l09gr01.badice.utils.HiscoresManager;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() == 0)
            game.setState(new MenuState(new Menu()));
=======
        if (getModel().getGameTimer().isPaused) getModel().resumeGameTimer();
        if (action == GUI.ACTION.QUIT || action == GUI.ACTION.PAUSE)
        {
            getModel().pauseGameTimer();
            game.setState(new PauseMenuState(new PauseMenu(getModel().getArena())));
        }
        else if (getModel().getFruit().isEmpty())
        {
            getModel().pauseGameTimer();
            if (getModel().getLevel() == game.getLevelUnlocks()) game.setLevelUnlocks(game.getLevelUnlocks() + 1);
            int newRank = HiscoresManager.findIndexToInsert(game.getHiscores(),getModel().getPlayerCharacter().getScore(), getModel().getGameTimer().getFormattedTime());
            if (newRank < 10) game.setState(new NewHiscoreMenuState(new NewHiscoreMenu(newRank,getModel().getPlayerCharacter().getScore(), getModel().getGameTimer().getFormattedTime())));
            else game.setState(new LevelCompletedMenuState(new LevelCompletedMenu(getModel().getLevel() + 1)));
        }
        else if(getModel().getPlayerCharacter().getHp() == 0)
        {
            getModel().pauseGameTimer();
            int newRank = HiscoresManager.findIndexToInsert(game.getHiscores(),getModel().getPlayerCharacter().getScore(), getModel().getGameTimer().getFormattedTime());
            if (newRank < 10) game.setState(new NewHiscoreMenuState(new NewHiscoreMenu(newRank,getModel().getPlayerCharacter().getScore(), getModel().getGameTimer().getFormattedTime())));
            else game.setState(new GameOverMenuState(new GameOverMenu(getModel().getLevel())));
        }
>>>>>>> Stashed changes
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}