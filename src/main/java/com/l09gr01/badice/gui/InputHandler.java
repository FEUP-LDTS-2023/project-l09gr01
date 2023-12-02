package com.l09gr01.badice.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.l09gr01.badice.model.Position;

import java.io.IOException;

public class InputHandler implements GUI {
    private final Screen screen;
    public InputHandler(Screen screen){
        this.screen = screen;
    }
    public InputHandler(int width, int height) throws IOException {
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }
    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'p') return ACTION.PAUSE;
        if(keyStroke.getKeyType() == KeyType.Escape) return ACTION.PAUSE;

        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ') return ACTION.ACTION;
        return ACTION.NONE;
    }

    @Override
    public void drawPlayerCharacter(Position position) {
        drawCharacter(position.getX(), position.getY(), 'H', "#90EE90");
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', "#AAAAAA");
    }

    @Override
    public void drawIce(Position position)
    {
        drawCharacter(position.getX(), position.getY(),'&', "#ADD8E6");
    }

    public void drawFruit(Position position) { drawCharacter(position.getX(), position.getY(), 'F', "#32A852");}
    @Override
    public void drawPowerUp(Position position)
    {
        drawCharacter(position.getX(), position.getY(),'P', "#FFA500");
    }
    @Override
    public void drawEasyMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), 'E', "#FF007F");
    }
    public void drawMediumMonster(Position position) { drawCharacter(position.getX(), position.getY(), 'M',"#FF007F" );}
    public void drawHardMonster(Position position) { drawCharacter(position.getX(),position.getY(), 'H', "#FF007F");}
    public void drawHeader(int level, int score, String time){
        TextGraphics tg = screen.newTextGraphics();
        tg.putString(0, 0, "Level " + level);
        tg.putString(15, 0, String.valueOf(score));
        tg.putString(35, 0, time);

    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY() + 1, text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}