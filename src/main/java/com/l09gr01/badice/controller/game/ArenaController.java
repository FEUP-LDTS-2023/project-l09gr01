package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GameTimer;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.menu.*;
import com.l09gr01.badice.state.*;
import com.l09gr01.badice.utils.GameStats;
import com.l09gr01.badice.utils.HiscoresManager;

import java.io.IOException;
import java.util.Random;


public class ArenaController extends GameController {
    private PlayerCharacterController playerCharacterController;
    private Player2CharacterController player2CharacterController;
    private MonsterEasyController monsterEasyController;
    private MonsterMediumController monsterMediumController;
    private MonsterHardController monsterHardController;
    private Random random = new Random();

    public ArenaController(Arena arena) {
        super(arena);

        this.playerCharacterController = new PlayerCharacterController(arena);
        this.player2CharacterController = new Player2CharacterController(arena);
        this.monsterEasyController = new MonsterEasyController(arena);
        this.monsterMediumController = new MonsterMediumController(arena);
        this.monsterHardController = new MonsterHardController(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (getModel().getGameTimer().isPaused) getModel().resumeGameTimer();
        if (shouldCreatePowerUp()) getModel().setPowerUp(getModel().spawnPowerUp());
        if (!KeybindManager.isIngame()) KeybindManager.setIngame(true);
        if (action == GUI.ACTION.QUIT || action == GUI.ACTION.PAUSE)
        {
            getModel().pauseGameTimer();
            KeybindManager.setIngame(false);
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
            if (!HiscoresManager.wasGamePlayed()) HiscoresManager.setWasGamePlayed(true);
            game.setState(new LevelCompletedMenuState(new LevelCompletedMenu(currentLevel,currentTimer.getFormattedTime(), currentScore)));
        }
        else if (getModel().existsP2() && (getModel().getPlayerCharacter().getHp() <= 0 || getModel().getPlayer2Character().getHp() <= 0)) {
                setGameOver(game);
            }
        else if (getModel().getPlayerCharacter().getHp() <= 0) {
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
        KeybindManager.setIngame(false);
    }
    private void setGameOver(Game game) {
        getModel().pauseGameTimer();
        int currentLevel = getModel().getLevel();
        int currentScore = getModel().getScore();
        GameTimer currentTimer = getModel().getGameTimer();
        setLevelScoreTimer(currentLevel, currentScore, currentTimer);
        if (!HiscoresManager.wasGamePlayed()) HiscoresManager.setWasGamePlayed(true);
        game.setState(new GameOverMenuState(new GameOverMenu(currentLevel, currentTimer.getFormattedTime(), currentScore)));
    }
    private boolean shouldCreatePowerUp() {
        if (!getModel().existsPowerUp()) {
            int randomNumber = random.nextInt(1000);
            return randomNumber <= 1;
        }
        return false;
    }
    public void setPlayerCharacterController(PlayerCharacterController playerCharacterController){
        this.playerCharacterController = playerCharacterController;
    }
    public void setPlayer2CharacterController(Player2CharacterController player2CharacterController){
        this.player2CharacterController = player2CharacterController;
    }
    public void setMonsterEasyController(MonsterEasyController monsterEasyController){
        this.monsterEasyController = monsterEasyController;
    }
    public void setMonsterMediumController(MonsterMediumController monsterMediumController){
        this.monsterMediumController = monsterMediumController;
    }
    public void setMonsterHardController(MonsterHardController monsterHardController){
        this.monsterHardController = monsterHardController;
    }
}