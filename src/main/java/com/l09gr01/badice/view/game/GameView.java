package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.gui.GameTimer;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.Element;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.game.observers.ScoreObserver;

import java.util.List;

public class GameView extends View<Arena> implements ScoreObserver {
    private final GameTimer gameTimer = new GameTimer();
    public GameView(Arena arena) {
        super(arena);
        gameTimer.start();
    }



    @Override
    public void drawElements(GUI gui) {
        gui.drawHeader(getModel().getLevel(),getModel().getPlayerCharacter().getScore(), gameTimer.getFormattedTime());
        drawElements(gui, getModel().getWalls(), new WallView());
        drawElements(gui, getModel().getMonsters(), new MonsterView());
        drawElement(gui, getModel().getPlayerCharacter(), new PlayerCharacterView());
        drawElements(gui, getModel().getFruit(), new FruitView());
        drawElements(gui, getModel().getIceBlocks(), new IceView());

    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementView<T> view) {
        for (T element : elements)
            drawElement(gui, element, view);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementView<T> view) {
        view.draw(element, gui);
    }
    public void updateScore(int newScore){
        getModel().getPlayerCharacter().setScore(getModel().getPlayerCharacter().getScore() + newScore);
    }
}
