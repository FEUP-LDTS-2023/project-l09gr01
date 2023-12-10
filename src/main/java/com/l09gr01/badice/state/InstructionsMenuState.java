package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.menu.InstructionsMenuController;
import com.l09gr01.badice.model.menu.InstructionsMenu;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.menu.InstructionsMenuView;

public class InstructionsMenuState extends State<InstructionsMenu>{
    public InstructionsMenuState(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected View<InstructionsMenu> getView() {
        return new InstructionsMenuView(getModel());
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return new InstructionsMenuController(getModel());
    }
}
