package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.LevelCompletedMenuController;
import com.l09gr01.badice.model.menu.LevelCompletedMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.LevelCompletedMenuView;

public class LevelCompletedMenuState extends State<LevelCompletedMenu>{
    public LevelCompletedMenuState(LevelCompletedMenu model) {
        super(model);
    }

    @Override
    protected View<LevelCompletedMenu> getView() {
        return new LevelCompletedMenuView(getModel());
    }

    @Override
    protected Controller<LevelCompletedMenu> getController() {
        return new LevelCompletedMenuController(getModel());
    }
}
