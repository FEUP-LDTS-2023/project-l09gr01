package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.Direction;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;

import static com.l09gr01.badice.model.Direction.*;

public class PlayerCharacterController extends GameController {

    private Direction lastDirection;
    public PlayerCharacterController(Arena arena) {
        super(arena);
    }

    public void movePlayerCharacterLeft() {
        if(lastDirection == LEFT){
            movePlayerCharacter(getModel().getPlayerCharacter().getPosition().getLeft());
        }
        else{
            getModel().getPlayerCharacter().setDirection(LEFT);
            lastDirection = LEFT;
        }
    }

    public void movePlayerCharacterRight() {
        if(lastDirection == RIGHT){
            movePlayerCharacter(getModel().getPlayerCharacter().getPosition().getRight());
        }
        else{
            getModel().getPlayerCharacter().setDirection(RIGHT);
            lastDirection = RIGHT;
        }
    }

    public void movePlayerCharacterUp() {
        if(lastDirection == UP){
            movePlayerCharacter(getModel().getPlayerCharacter().getPosition().getUp());
        }
        else{
            getModel().getPlayerCharacter().setDirection(UP);
            lastDirection = UP;
        }
    }

    public void movePlayerCharacterDown() {
        if(lastDirection == DOWN){
            movePlayerCharacter(getModel().getPlayerCharacter().getPosition().getDown());
        }
        else{
            getModel().getPlayerCharacter().setDirection(DOWN);
            lastDirection = DOWN;
        }
    }

    private void movePlayerCharacter(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayerCharacter().setPosition(position);
            if (getModel().isMonster(position)) getModel().getPlayerCharacter().decreaseHp();
            if (getModel().isFruit(position)) {
                getModel().getPlayerCharacter().pickUpFruit();
                getModel().removeFruit(position);
            }
        }
    }



    public void doAction(){

        Direction direction = getModel().getPlayerCharacter().getDirection(); // guarda a diraçao do jogador para que quando se constroi o gelo quando o jogador se virar o gelo continuar a ir em frente
        Position nextPosition = nextPosition(getModel().getPlayerCharacter().getPosition(),direction);
        if (getModel().isEmpty(nextPosition(getModel().getPlayerCharacter().getPosition(), direction)))
        {
            while(getModel().isEmpty(nextPosition))
            {
                getModel().createIce(nextPosition);
                nextPosition = nextPosition(nextPosition,direction);
            }
        }

        else if (getModel().isIce(nextPosition(getModel().getPlayerCharacter().getPosition(), direction))
        || getModel().isFruitInIce(nextPosition(getModel().getPlayerCharacter().getPosition(), direction)))
        {
            while(getModel().isIce(nextPosition))
            {
                getModel().destroyIce(nextPosition);
                nextPosition = nextPosition(nextPosition,direction);
            }
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerCharacterUp();
        if (action == GUI.ACTION.RIGHT) movePlayerCharacterRight();
        if (action == GUI.ACTION.DOWN) movePlayerCharacterDown();
        if (action == GUI.ACTION.LEFT) movePlayerCharacterLeft();
        if (action == GUI.ACTION.ACTION) doAction();
        }


    public Position nextPosition(Position position, Direction direction) // da te a proxima posiçao sempre na direçaoem que o Player estava virado a 1x que foi usado o doAction
    {
        switch (direction) {
            case UP:
                return new Position(position.getX(), position.getY() - 1);

            case DOWN:
                return new Position(position.getX(), position.getY() + 1);

            case RIGHT:
                return new Position(position.getX() + 1, position.getY());

            case LEFT:
                return new Position(position.getX() - 1, position.getY());

            default:
                return null;
        }
    }
}



