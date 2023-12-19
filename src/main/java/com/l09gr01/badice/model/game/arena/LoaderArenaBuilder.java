package com.l09gr01.badice.model.game.arena;

import com.l09gr01.badice.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.l09gr01.badice.utils.GameStats;

public class LoaderArenaBuilder{
    private final int level;
    private final List<String> lines;
    
    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;
        URL resource;
        if (GameStats.isSelected2Players()) resource = LoaderArenaBuilder.class.getResource("/levels/twoPlayerLevels/level" + level + ".lvl");
        else resource = LoaderArenaBuilder.class.getResource("/levels/onePlayerLevels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile(), StandardCharsets.UTF_8));

        lines = readLines(br);
    }
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setPlayerCharacter(createPlayerCharacter());
        arena.setPlayer2Character(createPlayer2Character());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setIceBlocks(createIceBlocks());
        arena.setFruit(createFruits());
        arena.setFruitInIce(createFruitInIce());
        arena.setLevel(level);

        return arena;
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    
    protected int getHeight() {
        return lines.size();
    }

    
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }

    protected List<Ice> createIceBlocks() {
        List<Ice> iceBlocks = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'O' || line.charAt(x) == 'U') iceBlocks.add(new Ice(x, y));
        }

        return iceBlocks;
    }

    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'E') monsters.add(new Monster(x, y, 1));
                if (line.charAt(x) == 'M') monsters.add(new Monster(x, y, 2));
                if (line.charAt(x) == 'H') monsters.add(new Monster(x, y, 3));
        }}

        return monsters;
    }

    protected PlayerCharacter createPlayerCharacter() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'G') return new PlayerCharacter(x, y);
            }
        }
        return null;
    }
    protected PlayerCharacter createPlayer2Character() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '2') return new PlayerCharacter(x, y);
            }
        }
        return null;
    }
    protected List<Fruit> createFruits() {
        List<Fruit> fruits = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'F' || line.charAt(x) == 'U') fruits.add(new Fruit(x, y));
        }
        return fruits;
    }
    protected List<FruitInIce> createFruitInIce() {
        List<FruitInIce> fruitInIce = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'U'){
                    fruitInIce.add(new FruitInIce(x, y));
                }
        }
        return fruitInIce;
    }

}
