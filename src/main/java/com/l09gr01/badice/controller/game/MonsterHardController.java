package com.l09gr01.badice.controller.game;

import com.l09gr01.badice.gui.GUI;
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
                if(monster.getDifficulty() == 3) moveMonster(monster);
            this.lastMovement = time;
        }
    }

    private void moveMonster(Monster monster) {

        Position closerPosition = closestToPlayer(monster);
        Position randomPosition = monster.getPosition().getRandomNeighbour();

        if(getModel().isEmpty(closerPosition))
        {
            monster.setPosition(closerPosition);
            if (getModel().getPlayerCharacter().getPosition().equals(closerPosition))
            {
                getModel().getPlayerCharacter().decreaseHp();
            }
        }

        else
        {
            if(getModel().isEmpty(randomPosition)) {
                monster.setPosition(randomPosition);

                if (getModel().getPlayerCharacter().getPosition().equals(closerPosition)) {
                    getModel().getPlayerCharacter().decreaseHp();
                }
            }
        }
        // hard algorithm here
    }

    public Position closestToPlayer(Monster monster) {
        Position playerP = getModel().getPlayerCharacter().getPosition();
        Position player2P = null;
        if (getModel().existsP2())  player2P = getModel().getPlayer2Character().getPosition();
        Position closest = null;
        double shortestDistance = Double.MAX_VALUE;

        List<Position> positions = new ArrayList<>();

        positions.add(new Position(monster.getPosition().getX() + 1, monster.getPosition().getY()));
        positions.add(new Position(monster.getPosition().getX(), monster.getPosition().getY() + 1));
        positions.add(new Position(monster.getPosition().getX(), monster.getPosition().getY() - 1));
        positions.add(new Position(monster.getPosition().getX() - 1, monster.getPosition().getY()));

        for (Position possiblePosition : positions) {
            double distance = calculateDistance(possiblePosition, playerP);
            double distance2 = 0;
            if (player2P != null) distance2 = calculateDistance(possiblePosition, player2P);
            double minDistance;
            if (distance2 != 0) minDistance = Math.min(distance, distance2);
            else minDistance = distance;

            if (minDistance < shortestDistance) {
                shortestDistance = minDistance;
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
