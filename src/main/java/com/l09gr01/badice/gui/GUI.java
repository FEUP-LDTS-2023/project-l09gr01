package com.l09gr01.badice.gui;

import com.googlecode.lanterna.gui2.TextBox;
import com.l09gr01.badice.Game;
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
    void drawFruitInIce(Position position);

    void drawText(Position position, String text, String color);

    void drawHeader(int level, int score, String time );
    void drawFooter(int p1Hp, int p2Hp, boolean selected2Players, int totalScore, int score, int level);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;



    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, ACTION,
        PAUSE, INPUT_CHAR, BACKSPACE, P2UP, P2DOWN, P2LEFT, P2RIGHT, P2ACTION,
        MOVE_UP,MOVE_DOWN,MOVE_LEFT,MOVE_RIGHT}
}
