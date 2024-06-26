package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.NewHiscoreMenuController;
import com.l09gr01.badice.model.menu.NewHiscoreMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.NewHiscoreMenuView;

public class NewHiscoreMenuState extends State<NewHiscoreMenu> {
    public NewHiscoreMenuState(NewHiscoreMenu model) {
        super(model);
    }

    @Override
    protected View<NewHiscoreMenu> getView() {
        return new NewHiscoreMenuView(getModel());
    }

    @Override
    protected Controller<NewHiscoreMenu> getController() {
        return new NewHiscoreMenuController(getModel());
    }
}
