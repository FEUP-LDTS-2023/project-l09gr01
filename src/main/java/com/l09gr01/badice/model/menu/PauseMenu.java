package com.l09gr01.badice.model.menu;

import com.l09gr01.badice.model.game.arena.Arena;

import java.util.Arrays;

public class PauseMenu extends Menu {
    private final Arena pausedArena;

    public PauseMenu(Arena pausedArena) {
        super();
        this.entries = Arrays.asList("RESUME GAME","OPTIONS","QUIT GAME");
        this.pausedArena = pausedArena;
    }

    public boolean isSelectedResume() {
        return isSelected(0);
    }
    public boolean isSelectedOptions() {
        return isSelected(1);
    }
    public boolean isSelectedQuit() {
        return isSelected(2);
    }
    public Arena getPausedArena(){
        return this.pausedArena;
    }
}
