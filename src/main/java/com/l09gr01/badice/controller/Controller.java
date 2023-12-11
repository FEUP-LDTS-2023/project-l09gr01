package com.l09gr01.badice.controller;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.model.menu.NewHiscoreMenu;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.state.NewHiscoreMenuState;
import com.l09gr01.badice.utils.GameStats;
import com.l09gr01.badice.utils.HiscoresManager;

import java.io.IOException;
import java.text.ParseException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;

    protected static void newHiscoreCheck(Game game) {
        if ((GameStats.getLevelTimers().get(0) == null) && (HiscoresManager.isNewHiscore(GameStats.getTotalScore(), GameStats.getTotalGameTime()))) {
            int newRank = HiscoresManager.findIndexToInsert(GameStats.getHiscores(), GameStats.getTotalScore(), GameStats.getTotalGameTime()) + 1;
            game.setState(new NewHiscoreMenuState(new NewHiscoreMenu(newRank, GameStats.getTotalScore(), GameStats.getTotalGameTime())));
        }
        else game.setState(new MainMenuState(new MainMenu()));
    }
}
