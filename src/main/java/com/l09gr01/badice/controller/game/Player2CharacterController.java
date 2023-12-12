package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.Game;
import com.l09gr01.badice.gui.GUI;
import com.l09gr01.badice.model.Direction;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;

import static com.l09gr01.badice.model.Direction.*;
import static com.l09gr01.badice.model.Direction.DOWN;

public class Player2CharacterController extends PlayerCharacterController {

    private Direction lastDirection;
    public Player2CharacterController(Arena arena) {
        super(arena);
    }

    public void movePlayer2CharacterLeft() {
        if(this.lastDirection == LEFT){
            movePlayer2Character(getModel().getPlayer2Character().getPosition().getLeft());
        }
        else{
            getModel().getPlayer2Character().setDirection(LEFT);
            this.lastDirection = LEFT;
        }
    }

    public void movePlayer2CharacterRight() {
        if(this.lastDirection == RIGHT){
            movePlayer2Character(getModel().getPlayer2Character().getPosition().getRight());
        }
        else{
            getModel().getPlayer2Character().setDirection(RIGHT);
            this.lastDirection = RIGHT;
        }
    }

    public void movePlayer2CharacterUp() {
        if(this.lastDirection == UP){
            movePlayer2Character(getModel().getPlayer2Character().getPosition().getUp());
        }
        else{
            getModel().getPlayer2Character().setDirection(UP);
            this.lastDirection = UP;
        }
    }

    public void movePlayer2CharacterDown() {
        if(this.lastDirection == DOWN){
            movePlayer2Character(getModel().getPlayer2Character().getPosition().getDown());
        }
        else{
            getModel().getPlayer2Character().setDirection(DOWN);
            this.lastDirection = DOWN;
        }
    }

    private void movePlayer2Character(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayer2Character().setPosition(position);
            if (getModel().isMonster(position)) getModel().getPlayer2Character().decreaseHp();
            if (getModel().isFruit(position)) {
                getModel().pickUpFruit();
                getModel().removeFruit(position);
            }
        }
    }



    public void doAction(){
        Direction direction = getModel().getPlayer2Character().getDirection();
        Position nextPosition = nextPosition(getModel().getPlayer2Character().getPosition(),direction);
        if (getModel().isEmpty(nextPosition(getModel().getPlayer2Character().getPosition(), direction)))
        {
            while(getModel().isEmpty(nextPosition))
            {
                getModel().createIce(nextPosition);
                nextPosition = nextPosition(nextPosition,direction);
            }
        }

        else if (getModel().isIce(nextPosition(getModel().getPlayer2Character().getPosition(), direction))
                || getModel().isFruitInIce(nextPosition(getModel().getPlayer2Character().getPosition(), direction)))
        {
            while(getModel().isIce(nextPosition))
            {
                getModel().destroyIce(nextPosition);
                nextPosition = nextPosition(nextPosition,direction);
            }
        }
    }
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.P2UP) movePlayer2CharacterUp();
        if (action == GUI.ACTION.P2RIGHT) movePlayer2CharacterRight();
        if (action == GUI.ACTION.P2DOWN) movePlayer2CharacterDown();
        if (action == GUI.ACTION.P2LEFT) movePlayer2CharacterLeft();
        if (action == GUI.ACTION.P2ACTION) doAction();
    }
}