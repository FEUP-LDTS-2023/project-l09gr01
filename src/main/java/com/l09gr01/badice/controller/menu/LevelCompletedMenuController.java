package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.game.arena.LoaderArenaBuilder;
import com.l09gr01.badice.model.menu.LevelCompletedMenu;
import com.l09gr01.badice.model.menu.LevelSelectMenu;
import com.l09gr01.badice.state.GameState;
import com.l09gr01.badice.state.LevelSelectMenuState;

import java.io.IOException;

public class LevelCompletedMenuController extends Controller<LevelCompletedMenu> {
    public LevelCompletedMenuController(LevelCompletedMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedTryAgain() && (getModel().getLevel() == getModel().getMaxLevel())) {
                    game.setState(new GameState(new LoaderArenaBuilder(getModel().getLevel()).createArena()));
                }
                if (getModel().isSelectedNextLevel() && (getModel().getLevel() < getModel().getMaxLevel())) {
                    game.setState(new GameState(new LoaderArenaBuilder(getModel().getLevel() + 1).createArena()));
                }
                if (getModel().isSelectedChooseLevel())
                    game.setState(new LevelSelectMenuState(new LevelSelectMenu()));
                if (getModel().isSelectedMainMenu()) {
                    newHiscoreCheck(game);
                }
                if (getModel().isSelectedQuit()) game.setState(null);
                }
        }
    }
