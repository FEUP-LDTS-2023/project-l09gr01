package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.model.menu.InstructionsMenu;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.state.MainMenuState;

import java.io.IOException;

public class InstructionsMenuController extends Controller<InstructionsMenu> {
    public InstructionsMenuController(InstructionsMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.SELECT) {
            if (getModel().isSelectedBack()) game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
