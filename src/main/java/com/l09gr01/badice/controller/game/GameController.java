package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.controller.Controller;
import com.l09gr01.badice.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
