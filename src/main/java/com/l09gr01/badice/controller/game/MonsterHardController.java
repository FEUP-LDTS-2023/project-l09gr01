package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.model.game.arena.Arena;
import com.l09gr01.badice.model.game.elements.Monster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonsterHardController extends GameController implements MonsterController {
    private long lastMovement;

    public MonsterHardController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {


        if (time - lastMovement > 300) {
            for (Monster monster : getModel().getMonsters())
                moveMonster(monster);
            this.lastMovement = time;
        }
    }

    private void moveMonster(Monster monster) {

        Position closerPosition = closestToPlayer(monster);

        if(getModel().isEmpty(closerPosition))
        {
            monster.setPosition(closerPosition);
            if (getModel().getPlayerCharacter().getPosition().equals(closerPosition))
            {
                getModel().getPlayerCharacter().decreaseHp();
            }
        }
        // hard algorithm here
    }

    public Position closestToPlayer(Monster monster) {
        Position playerP = getModel().getPlayerCharacter().getPosition();
        Position closest = null;
        double shortestDistance = Double.MAX_VALUE;

        List<Position> positions = new ArrayList<>();

        positions.add(new Position(monster.getPosition().getX() + 1, monster.getPosition().getY()));
        positions.add(new Position(monster.getPosition().getX(), monster.getPosition().getY() + 1));
        positions.add(new Position(monster.getPosition().getX(), monster.getPosition().getY() - 1));
        positions.add(new Position(monster.getPosition().getX() - 1, monster.getPosition().getY()));

        for (Position possiblePosition : positions) {
            double distance = calculateDistance(possiblePosition, playerP);

            if (distance < shortestDistance) {
                shortestDistance = distance;
                closest = possiblePosition;
            }
        }

        return closest;
    }

    private static double calculateDistance(Position mobPosition, Position playerPosition) {
        int deltaX = Math.abs(mobPosition.getX() - playerPosition.getX());
        int deltaY = Math.abs(mobPosition.getY() - playerPosition.getY());
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
