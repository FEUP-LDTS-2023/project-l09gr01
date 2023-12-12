package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.model.menu.OptionsMenu;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.utils.GameStats;

import java.io.IOException;

public class OptionsMenuController extends Controller<OptionsMenu> {
    public OptionsMenuController(OptionsMenu menu) {
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
                if (getModel().isSelected2PlayerMode()) GameStats.setSelected2Players(!GameStats.isSelected2Players());
                if (getModel().isSelectedSetP1MoveUp()) KeybindManager.setKeybind(GUI.ACTION.UP,game.getGui().getUserInput());
                if (getModel().isSelectedMainMenu()) game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
