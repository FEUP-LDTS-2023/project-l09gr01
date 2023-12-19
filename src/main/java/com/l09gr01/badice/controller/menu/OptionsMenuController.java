package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.model.menu.OptionsMenu;
import com.l09gr01.badice.model.menu.PauseMenu;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.state.PauseMenuState;
import com.l09gr01.badice.utils.GameStats;

import java.io.IOException;

public class OptionsMenuController extends Controller<OptionsMenu> {
    public OptionsMenuController(OptionsMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            // getModel().setSelectPressed();
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                getModel().setSelectPressed();
                if (getModel().isSelected2PlayerMode()){
                    GameStats.setSelected2Players(!GameStats.isSelected2Players());
                }
                if (getModel().isSelectedSetP1MoveUp()) {
                    KeybindManager.setKeybind(GUI.ACTION.MOVE_UP, game.getGui().getUserInput());
                    // getModel().setSelectPressed();
                }
                if (getModel().isSelectedSetP1MoveDown()) KeybindManager.setKeybind(GUI.ACTION.MOVE_DOWN,game.getGui().getUserInput());
                if (getModel().isSelectedSetP1MoveLeft()) KeybindManager.setKeybind(GUI.ACTION.MOVE_LEFT,game.getGui().getUserInput());
                if (getModel().isSelectedSetP1MoveRight()) KeybindManager.setKeybind(GUI.ACTION.MOVE_RIGHT,game.getGui().getUserInput());
                if (getModel().isSelectedSetP1Action()) KeybindManager.setKeybind(GUI.ACTION.P1ACTION,game.getGui().getUserInput());
                if (getModel().isSelectedSetP2MoveUp()) KeybindManager.setKeybind(GUI.ACTION.P2UP,game.getGui().getUserInput());
                if (getModel().isSelectedSetP2MoveDown()) KeybindManager.setKeybind(GUI.ACTION.P2DOWN,game.getGui().getUserInput());
                if (getModel().isSelectedSetP2MoveLeft()) KeybindManager.setKeybind(GUI.ACTION.P2LEFT,game.getGui().getUserInput());
                if (getModel().isSelectedSetP2MoveRight()) KeybindManager.setKeybind(GUI.ACTION.P2RIGHT,game.getGui().getUserInput());
                if (getModel().isSelectedSetP2Action()) KeybindManager.setKeybind(GUI.ACTION.P2ACTION,game.getGui().getUserInput());
                if (getModel().isSelectedMainMenu()) game.setState(new MainMenuState(new MainMenu()));
                if (getModel().isSelectedResume()) game.setState(new PauseMenuState(new PauseMenu(getModel().getPausedArena())));
                break;
            default:
                break;
        }
    }
}
