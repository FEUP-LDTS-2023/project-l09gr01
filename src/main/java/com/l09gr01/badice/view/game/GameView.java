package com.l09gr01.badice.view.game;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.Element;
import com.l09gr01.badice.view.View;

import java.util.List;

public class GameView extends View<Arena> {
    public GameView(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallView());
        drawElements(gui, getModel().getMonsters(), new MonsterView());
        drawElement(gui, getModel().getPlayerCharacter(), new PlayerCharacterView());

    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementView<T> view) {
        for (T element : elements)
            drawElement(gui, element, view);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementView<T> view) {
        view.draw(element, gui);
    }
}
