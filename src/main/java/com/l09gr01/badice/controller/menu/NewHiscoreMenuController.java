package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.gui.InputHandler;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.model.menu.NewHiscoreMenu;
import com.l09gr01.badice.state.MainMenuState;
import com.l09gr01.badice.utils.HiscoreEntry;
import com.l09gr01.badice.utils.HiscoresManager;

import java.io.IOException;
import java.util.List;


public class NewHiscoreMenuController extends Controller<NewHiscoreMenu> {
    private final StringBuilder stringBuilder = new StringBuilder();

    public NewHiscoreMenuController(NewHiscoreMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        InputHandler inputHandler = game.getGui();
        switch (action) {
            case INPUT_CHAR:
                char inputChar = inputHandler.getLastInputCharacter();
                handleInputCharacter(inputChar);
                String name = stringBuilder.toString();
                getModel().setEntry(1, name);
                break;
            case SELECT:
                name = stringBuilder.toString();
                getModel().setNewName(name);
                HiscoreEntry newEntry = getModel().createHiscoreEntry();
                List<HiscoreEntry> newHiscores = HiscoresManager.addHiscoreEntry(game.getHiscores(),newEntry);
                game.setHiscores(newHiscores);
                HiscoresManager.saveHiscores(newHiscores, "/data/hiscores.txt");
                game.setState(new MainMenuState(new MainMenu()));
                break;
            case BACKSPACE:
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                name = stringBuilder.toString();
                getModel().setEntry(1, name);
                break;
        }
    }
    private void handleInputCharacter(char inputChar) {
        if (Character.isLetter(inputChar)) {
            stringBuilder.append(inputChar);
        }
    }
}