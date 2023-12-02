package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.model.game.arena.LoaderArenaBuilder;
import com.l09gr01.badice.model.menu.LevelSelectMenu;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.state.GameState;
import com.l09gr01.badice.state.MainMenuState;
import com.sun.tools.javac.Main;

import java.io.IOException;

public class LevelSelectMenuController extends Controller<LevelSelectMenu> {
    public LevelSelectMenuController(LevelSelectMenu menu) {
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
                if (getModel().isSelectedLevel1()) {
                    if (game.getLevelUnlocks() >= 1)
                        game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                    else break;
                }
                if (getModel().isSelectedLevel2()) {
                    if (game.getLevelUnlocks() >= 2)
                        game.setState(new GameState(new LoaderArenaBuilder(2).createArena()));
                    else break;
                }
                if (getModel().isSelectedLevel3()) {
                    if (game.getLevelUnlocks() >= 3)
                        game.setState(new GameState(new LoaderArenaBuilder(3).createArena()));
                    else break;
                }
                if (getModel().isSelectedBack()) {
                    game.setState(new MainMenuState(new MainMenu()));
                }
        }
    }
}
