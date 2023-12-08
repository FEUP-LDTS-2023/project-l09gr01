package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.GameOverMenuController;
import com.l09gr01.badice.model.menu.GameOverMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.GameOverMenuView;

public class GameOverMenuState extends State<GameOverMenu>{
    public GameOverMenuState(GameOverMenu model) {
        super(model);
    }

    @Override
    protected View<GameOverMenu> getView() {
        return new GameOverMenuView(getModel());
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverMenuController(getModel());
    }
}
