package com.aor.hero.states;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.MenuController;
import com.l09gr01.badice.model.menu.Menu;
import com.l09gr01.badice.state.State;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.MenuView;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected View<Menu> getView() {
        return new MenuView(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
