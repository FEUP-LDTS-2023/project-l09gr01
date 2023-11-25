package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;

public class PlayerCharacterController extends GameController {
    public PlayerCharacterController(Arena arena) {
        super(arena);
    }

    public void movePlayerCharacterLeft() {
        moveHero(getModel().getPlayerCharacter().getPosition().getLeft());
    }

    public void movePlayerCharacterRight() {
        moveHero(getModel().getPlayerCharacter().getPosition().getRight());
    }

    public void movePlayerCharacterUp() {
        moveHero(getModel().getPlayerCharacter().getPosition().getUp());
    }

    public void movePlayerCharacterDown() {
        moveHero(getModel().getPlayerCharacter().getPosition().getDown());
    }

    private void moveHero(Position position) {
        //if same position as Monster game over(?)
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerCharacterUp();
        if (action == GUI.ACTION.RIGHT) movePlayerCharacterRight();
        if (action == GUI.ACTION.DOWN) movePlayerCharacterDown();
        if (action == GUI.ACTION.LEFT) movePlayerCharacterLeft();
    }
}