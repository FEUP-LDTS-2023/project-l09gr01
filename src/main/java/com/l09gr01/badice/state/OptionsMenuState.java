package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.OptionsMenuController;
import com.l09gr01.badice.model.menu.OptionsMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.OptionsMenuView;

public class OptionsMenuState extends State<OptionsMenu>{
    public OptionsMenuState(OptionsMenu model) {
        super(model);
    }

    @Override
    protected View<OptionsMenu> getView() {
        return new OptionsMenuView(getModel());
    }

    @Override
    protected Controller<OptionsMenu> getController() {
        return new OptionsMenuController(getModel());
    }
}
