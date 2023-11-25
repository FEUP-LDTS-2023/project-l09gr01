package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.model.menu.HiscoresMenu;
import com.l09gr01.badice.model.menu.LevelSelectMenu;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.state.MainMenuState;

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
                if (getModel().isSelectedLevel1()) game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
