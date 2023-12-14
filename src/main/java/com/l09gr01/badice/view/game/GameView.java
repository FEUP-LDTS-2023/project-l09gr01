package com.l09gr01.badice.view.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.gui.GameTimer;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.Element;
import com.l09gr01.badice.utils.GameStats;
import com.l09gr01.badice.view.View;
import com.l09gr01.badice.view.game.observers.ScoreObserver;

import java.util.List;

public class GameView extends View<Arena> implements ScoreObserver {
    public GameView(Arena arena) {
        super(arena);
    }



    @Override
    public void drawElements(GUI gui) {
        gui.drawHeader(getModel().getLevel(),getModel().getScore(), getModel().getGameTimer().getFormattedTime());
        drawElements(gui, getModel().getWalls(), new WallView());
        drawElement(gui, getModel().getPlayerCharacter(), new PlayerCharacterView());
        if (getModel().existsP2()) drawElement(gui, getModel().getPlayer2Character(), new PlayerCharacterView());
        if (getModel().getFruit() != null) drawElements(gui, getModel().getFruit(), new FruitView());
        if (getModel().existsPowerUp()) drawElement(gui, getModel().getPowerUp(), new PowerUpView());
        if (getModel().getIceBlocks() != null) drawElements(gui, getModel().getIceBlocks(), new IceView());
        if (getModel().getFruitInIce() != null) drawElements(gui, getModel().getFruitInIce(), new FruitInIceView());
        drawElements(gui, getModel().getMonsters(), new MonsterView());
        if (getModel().existsP2())
            gui.drawFooter(getModel().getPlayerCharacter().getHp(),getModel().getPlayer2Character().getHp(),
                    GameStats.isSelected2Players(), GameStats.getTotalScore(),getModel().getScore(),
                    getModel().getLevel());
        else gui.drawFooter(getModel().getPlayerCharacter().getHp(),0,GameStats.isSelected2Players(),
                GameStats.getTotalScore(),getModel().getScore(), getModel().getLevel());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementView<T> view) {
        for (T element : elements)
            drawElement(gui, element, view);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementView<T> view) {
        view.draw(element, gui);
    }
    public void updateScore(int newScore){
        getModel().setScore(getModel().getScore() + newScore);
    }
}
