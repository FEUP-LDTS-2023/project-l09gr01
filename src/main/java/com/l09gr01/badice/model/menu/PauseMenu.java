package com.l09gr01.badice.model.menu;

import com.l09gr01.badice.model.game.arena.Arena;

import java.util.Arrays;

public class PauseMenu extends Menu {
    private static Arena pausedArena;

    public PauseMenu(Arena pausedArena) {
        super();
        this.entries = Arrays.asList("Resume Game","Options","Quit Game");
        PauseMenu.pausedArena = pausedArena;
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
    public static Arena getPausedArena(){
        return PauseMenu.pausedArena;
    }
}
