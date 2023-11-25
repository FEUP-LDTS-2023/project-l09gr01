package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.HiscoresMenuController;
import com.l09gr01.badice.controller.menu.MainMenuController;
import com.l09gr01.badice.model.menu.HiscoresMenu;
import com.l09gr01.badice.model.menu.MainMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.HiscoresMenuView;
import com.l09gr01.badice.view.menu.MainMenuView;

public class HiscoresMenuState extends State<HiscoresMenu>{
    public HiscoresMenuState(HiscoresMenu model) {
        super(model);
    }

    @Override
    protected View<HiscoresMenu> getView() {
        return new HiscoresMenuView(getModel());
    }

    @Override
    protected Controller<HiscoresMenu> getController() {
        return new HiscoresMenuController(getModel());
    }
}
