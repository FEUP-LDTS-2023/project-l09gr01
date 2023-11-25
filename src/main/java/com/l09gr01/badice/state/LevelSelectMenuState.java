package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.LevelSelectMenuController;
import com.l09gr01.badice.model.menu.LevelSelectMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.LevelSelectMenuView;

public class LevelSelectMenuState extends State<LevelSelectMenu>{
    public LevelSelectMenuState(LevelSelectMenu model) {
        super(model);
    }

    @Override
    protected View<LevelSelectMenu> getView() {
        return new LevelSelectMenuView(getModel());
    }

    @Override
    protected Controller<LevelSelectMenu> getController() {
        return new LevelSelectMenuController(getModel());
    }
}
