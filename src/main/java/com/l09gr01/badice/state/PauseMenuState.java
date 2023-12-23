package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.PauseMenuController;
import com.l09gr01.badice.model.menu.PauseMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.PauseMenuView;

public class PauseMenuState extends State<PauseMenu>{
    public PauseMenuState(PauseMenu model) {
        super(model);
    }

    @Override
    protected View<PauseMenu> getView() {
        return new PauseMenuView(getModel());
    }

    @Override
    protected Controller<PauseMenu> getController() {
        return new PauseMenuController(getModel());
    }
}
