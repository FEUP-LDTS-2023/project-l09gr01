package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.menu.*;
import com.l09gr01.badice.state.*;
import com.l09gr01.badice.utils.HiscoresManager;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

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
            int newRank = HiscoresManager.findIndexToInsert(game.getHiscores(),getModel().getPlayerCharacter().getScore(), getModel().getGameTimer().getFormattedTime()) + 1;
            if (newRank <= HiscoresManager.getLowestRank()) game.setState(new NewHiscoreMenuState(new NewHiscoreMenu(newRank,getModel().getPlayerCharacter().getScore(), getModel().getGameTimer().getFormattedTime())));
            else game.setState(new LevelCompletedMenuState(new LevelCompletedMenu(getModel().getLevel() + 1)));
        }
        else if(getModel().getPlayerCharacter().getHp() == 0)
        {
            getModel().pauseGameTimer();
            int newRank = HiscoresManager.findIndexToInsert(game.getHiscores(),getModel().getPlayerCharacter().getScore(), getModel().getGameTimer().getFormattedTime())+1;
            if (newRank < HiscoresManager.getLowestRank()) game.setState(new NewHiscoreMenuState(new NewHiscoreMenu(newRank,getModel().getPlayerCharacter().getScore(), getModel().getGameTimer().getFormattedTime())));
            else game.setState(new GameOverMenuState(new GameOverMenu(getModel().getLevel())));
        }
        else {
            playerCharacterController.step(game, action, time);
            monsterEasyController.step(game, action, time);
            monsterMediumController.step(game,action,time);
            monsterHardController.step(game,action,time);
        }
    }
}