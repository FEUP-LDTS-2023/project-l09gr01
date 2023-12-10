package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.GameSavedMenuController;
import com.l09gr01.badice.model.menu.GameSavedMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.GameSavedMenuView;

public class GameSavedMenuState extends State<GameSavedMenu> {
    public GameSavedMenuState(GameSavedMenu model) {
        super(model);
    }

    @Override
    protected View<GameSavedMenu> getView() {
        return new GameSavedMenuView(getModel());
    }

    @Override
    protected Controller<GameSavedMenu> getController() {
        return new GameSavedMenuController(getModel());
    }
}
