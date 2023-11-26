package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.MainMenuController;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.MainMenuView;

public class MainMenuState extends State<MainMenu>{
    public MainMenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected View<MainMenu> getView() {
        return new MainMenuView(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
