package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.model.game.arena.LoaderArenaBuilder;
import com.l09gr01.badice.model.menu.Menu;
import com.l09gr01.badice.state.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
        }
    }
}