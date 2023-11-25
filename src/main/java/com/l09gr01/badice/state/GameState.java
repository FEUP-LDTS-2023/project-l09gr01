package com.l09gr01.badice.state;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.controller.game.ArenaController;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.game.GameView;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected View<Arena> getView() {
        return new GameView(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}