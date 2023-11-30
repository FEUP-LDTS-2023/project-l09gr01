package com.l09gr01.badice.gui;

import com.l09gr01.badice.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPlayerCharacter(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawIce(Position position);

    void drawPowerUp(Position position);

    void drawFruit(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, ACTION, PAUSE}
}
