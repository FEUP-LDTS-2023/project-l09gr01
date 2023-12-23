package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.gui.KeybindManager;
import com.l09gr01.badice.model.menu.HiscoresMenu;
import com.l09gr01.badice.model.menu.NewHiscoreMenu;
import com.l09gr01.badice.state.HiscoresMenuState;
import com.l09gr01.badice.utils.GameStats;
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
        switch (action) {
            case INPUT_CHAR:
                char inputChar = game.getGui().getLastInputCharacter();
                handleInputCharacter(inputChar);
                String name = stringBuilder.toString();
                getModel().setEntry(1, name);
                break;
            case SELECT:
                String finalName = stringBuilder.toString();
                getModel().setNewName(finalName);
                HiscoreEntry newEntry = getModel().createHiscoreEntry();
                List<HiscoreEntry> newHiscores = HiscoresManager.addHiscoreEntry(GameStats.getHiscores(), newEntry);
                GameStats.setHiscores(newHiscores);
                HiscoresManager.saveHiscores(newHiscores, "data/hiscores.txt");
                KeybindManager.setCharacterInputMode(false);
                if (HiscoresManager.wasGamePlayed()) HiscoresManager.setWasGamePlayed(false);
                game.setState(new HiscoresMenuState(new HiscoresMenu()));
                break;
            case BACKSPACE:
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                String newName = stringBuilder.toString();
                getModel().setEntry(1, newName);
                break;
            default:
                break;
        }
    }
    private void handleInputCharacter(char inputChar) {
        if (Character.isLetter(inputChar)) {
            stringBuilder.append(inputChar);
        }
    }
}