package com.l09gr01.badice.gui;

import com.l09gr01.badice.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawUpPlayerCharacter(Position position);
    void drawDownPlayerCharacter(Position position);
    void drawLeftPlayerCharacter(Position position);
    void drawRightPlayerCharacter(Position position);

    void drawWall(Position position);

    void drawEasyMonster(Position position);
    void drawMediumMonster(Position position);
    void drawHardMonster(Position position);

    void drawIce(Position position);

    void drawPowerUp(Position position);

    void drawFruit(Position position);

    void drawText(Position position, String text, String color);

    void drawHeader(int level, int score, String time );

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, ACTION, PAUSE}
}
