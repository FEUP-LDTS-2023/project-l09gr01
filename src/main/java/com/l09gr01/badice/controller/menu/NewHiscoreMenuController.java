package com.l09gr01.badice.controller.menu;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.model.menu.NewHiscoreMenu;
import com.l09gr01.badice.state.MainMenuState;

import java.io.IOException;
import java.util.Scanner;


public class NewHiscoreMenuController extends Controller<NewHiscoreMenu> {
    private final Scanner scanner = new Scanner(System.in);
    private final StringBuilder stringBuilder = new StringBuilder();

    public NewHiscoreMenuController(NewHiscoreMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (stringBuilder.length() < 5 && scanner.hasNext()) {
            char inputChar = scanner.next().charAt(0);
            if (Character.isLetter(inputChar)) {
                stringBuilder.append(Character.toUpperCase(inputChar));
                String name = stringBuilder.toString();
                getModel().setEntry(1, name);
            }
        } else {
            game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
