package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GameTimer;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.menu.*;
import com.l09gr01.badice.state.*;
import com.l09gr01.badice.utils.GameStats;

import java.io.IOException;


public class ArenaController extends GameController {
    private final PlayerCharacterController playerCharacterController;
    private final Player2CharacterController player2CharacterController;
    private final MonsterEasyController monsterEasyController;
    private final MonsterMediumController monsterMediumController;
    private final MonsterHardController monsterHardController;

    public ArenaController(Arena arena) {
        super(arena);

        this.playerCharacterController = new PlayerCharacterController(arena);
        this.player2CharacterController = new Player2CharacterController(arena);
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
            int currentLevel = getModel().getLevel();
            int currentScore = getModel().getScore();
            GameTimer currentTimer = getModel().getGameTimer();
            if (currentLevel == GameStats.getLevelsUnlocked()) {
                GameStats.setLevelsUnlocked(GameStats.getLevelsUnlocked()+1);
            }
            setLevelScoreTimer(currentLevel, currentScore, currentTimer);
            game.setState(new LevelCompletedMenuState(new LevelCompletedMenu(currentLevel,currentTimer.getFormattedTime(), currentScore)));
        }
        else if (getModel().existsP2() && (getModel().getPlayerCharacter().getHp() == 0 || getModel().getPlayer2Character().getHp() == 0)) {
                setGameOver(game);
            }
        else if (getModel().getPlayerCharacter().getHp() == 0) {
            setGameOver(game);
        }
        else {
            playerCharacterController.step(game, action, time);
            if (getModel().existsP2()) player2CharacterController.step(game,action,time);
            monsterEasyController.step(game, action, time);
            monsterMediumController.step(game,action,time);
            monsterHardController.step(game,action,time);
        }
    }
    private void setLevelScoreTimer(int currentLevel, int currentScore, GameTimer currentTimer) {
        if (GameStats.getLevelTimer(currentLevel) == null || currentScore > GameStats.getLevelScore(currentLevel)){
            GameStats.setLevelScore(currentLevel, currentScore);
            GameStats.setLevelTimer(currentLevel,currentTimer.getFormattedTime());
        }
        else if (currentScore == GameStats.getLevelScore(currentLevel)
                && (currentTimer.compareTo(new GameTimer(GameStats.getLevelTimer(currentLevel))) < 0)){
            GameStats.setLevelTimer(currentLevel,currentTimer.getFormattedTime());
        }
    }
    private void setGameOver(Game game) {
        getModel().pauseGameTimer();
        int currentLevel = getModel().getLevel();
        int currentScore = getModel().getScore();
        GameTimer currentTimer = getModel().getGameTimer();
        setLevelScoreTimer(currentLevel, currentScore, currentTimer);
        game.setState(new GameOverMenuState(new GameOverMenu(currentLevel, currentTimer.getFormattedTime(), currentScore)));
    }
}