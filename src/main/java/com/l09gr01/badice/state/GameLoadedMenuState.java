package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.GameLoadedMenuController;
import com.l09gr01.badice.model.menu.GameLoadedMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.GameLoadedMenuView;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameLoadedMenuState extends State<GameLoadedMenu>{
    public GameLoadedMenuState(GameLoadedMenu model) {
        super(model);
    }

    @Override
    protected View<GameLoadedMenu> getView() {
        return new GameLoadedMenuView(getModel());
    }

    @Override
    protected Controller<GameLoadedMenu> getController() {
        return new GameLoadedMenuController(getModel());
    }
}
