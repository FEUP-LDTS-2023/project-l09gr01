package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.model.menu.HiscoresMenu;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.state.MainMenuState;

import java.io.IOException;

public class HiscoresMenuController extends Controller<HiscoresMenu> {
    public HiscoresMenuController(HiscoresMenu menu) {
        super(menu);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.SELECT) {
            if (getModel().isSelectedOk()) game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
