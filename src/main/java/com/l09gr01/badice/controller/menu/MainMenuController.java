package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.model.game.arena.LoaderArenaBuilder;
import com.l09gr01.badice.model.menu.*;
import com.l09gr01.badice.state.*;
import com.l09gr01.badice.utils.LoadLevelUnlocks;
import com.l09gr01.badice.utils.SaveLevelUnlocks;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu menu) {
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
                if (getModel().isSelectedChooseLevel()) game.setState(new LevelSelectMenuState(new LevelSelectMenu()));
                if (getModel().isSelectedSave()) {
                    SaveLevelUnlocks.saveLevelUnlocks(game.getLevelUnlocks(), "data/saveFile.txt");
                    game.setState(new GameSavedMenuState(new GameSavedMenu()));
                }
                if (getModel().isSelectedLoad()) {
                    int savedProgress = LoadLevelUnlocks.loadLevelUnlocks("data/saveFile.txt");
                    game.setLevelUnlocks(savedProgress);
                    game.setState(new GameLoadedMenuState(new GameLoadedMenu()));
                }
                if (getModel().isSelectedOptions()) game.setState(new OptionsMenuState(new OptionsMenu()));
                if (getModel().isSelectedInstructions()) game.setState(new InstructionsMenuState(new InstructionsMenu()));
                if (getModel().isSelectedHiscores()) game.setState(new HiscoresMenuState(new HiscoresMenu()));
                if (getModel().isSelectedNew()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
        }
    }
}