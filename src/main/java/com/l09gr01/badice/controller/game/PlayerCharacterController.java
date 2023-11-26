package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.Direction;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;

public class PlayerCharacterController extends GameController {
    public PlayerCharacterController(Arena arena) {
        super(arena);
    }

    public void movePlayerCharacterLeft() {
        movePlayerCharacter(getModel().getPlayerCharacter().getPosition().getLeft());
    }

    public void movePlayerCharacterRight() {
        movePlayerCharacter(getModel().getPlayerCharacter().getPosition().getRight());
    }

    public void movePlayerCharacterUp() {
        movePlayerCharacter(getModel().getPlayerCharacter().getPosition().getUp());
    }

    public void movePlayerCharacterDown() {
        movePlayerCharacter(getModel().getPlayerCharacter().getPosition().getDown());
    }

    private void movePlayerCharacter(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayerCharacter().setPosition(position);
            if (getModel().isMonster(position)) getModel().getPlayerCharacter().decreaseHp();
        }
    }

    public void doAction(){
        if (getModel().isEmpty(getModel().getPlayerCharacter().getFront()) && !getModel().isMonster(getModel().getPlayerCharacter().getFront())) getModel().createIce(getModel().getPlayerCharacter().getDirection(),getModel().getPlayerCharacter().getFront());
        else if (getModel().isIce(getModel().getPlayerCharacter().getFront())) getModel().destroyIce(getModel().getPlayerCharacter().getDirection(), getModel().getPlayerCharacter().getFront());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerCharacterUp();
        if (action == GUI.ACTION.RIGHT) movePlayerCharacterRight();
        if (action == GUI.ACTION.DOWN) movePlayerCharacterDown();
        if (action == GUI.ACTION.LEFT) movePlayerCharacterLeft();
        if (action == GUI.ACTION.ACTION) doAction();
        }
    }
