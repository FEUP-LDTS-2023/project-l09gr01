package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.menu.OptionsMenu;
import com.l09gr01.badice.model.menu.PauseMenu;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.state.GameState;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.state.OptionsMenuState;

import java.io.IOException;

public class PauseMenuController extends Controller<PauseMenu> {
    public PauseMenuController(PauseMenu menu) {
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
                if (getModel().isSelectedResume()) {
                    game.setState(new GameState(getModel().getPausedArena()));
                }
                if (getModel().isSelectedOptions()) game.setState(new OptionsMenuState(new OptionsMenu(getModel().getPausedArena())));
                if (getModel().isSelectedQuit()) game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
