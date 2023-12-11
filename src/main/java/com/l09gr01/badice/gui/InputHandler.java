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
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.l09gr01.badice.Game;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.state.NewHiscoreMenuState;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class InputHandler implements GUI {
    private final Screen screen;
    private char lastInputCharacter;
    public InputHandler(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
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
    private Terminal createTerminal(int width, int height,AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }
    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/badice_font.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character) {
            char inputChar = keyStroke.getCharacter();
            if (Character.isLetter(inputChar)) {
                lastInputCharacter = inputChar;
                return ACTION.INPUT_CHAR;
            }
        }
        if (keyStroke.getKeyType() == KeyType.Backspace) return ACTION.BACKSPACE;
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
    public char getLastInputCharacter() {
        return lastInputCharacter;
    }

    @Override
    public void drawUpPlayerCharacter(Position position) {
        drawCharacter(position.getX(), position.getY(), '%', "#90EE90");
    }
    public void drawDownPlayerCharacter(Position position) {
        drawCharacter(position.getX(), position.getY(), '$', "#90EE90");
    }
    public void drawLeftPlayerCharacter(Position position) {
        drawCharacter(position.getX(), position.getY(), '_', "#90EE90");
    }
    public void drawRightPlayerCharacter(Position position) {
        drawCharacter(position.getX(), position.getY(), '^', "#90EE90");
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

    public void drawFruit(Position position) { drawCharacter(position.getX(), position.getY(), '~', "#32A852");}

    public void drawFruitInIce(Position position) { drawCharacter(position.getX(), position.getY(), '@', "#ADD8E6");}
    @Override
    public void drawPowerUp(Position position)
    {
        drawCharacter(position.getX(), position.getY(),'P', "#FFA500");
    }
    @Override
    public void drawEasyMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), '|', "#FF007F");
    }
    public void drawMediumMonster(Position position) { drawCharacter(position.getX(), position.getY(), '{',"#FF007F" );}
    public void drawHardMonster(Position position) { drawCharacter(position.getX(),position.getY(), '}', "#FF007F");}
    public void drawHeader(int level, int score, String time){
        TextGraphics tg = screen.newTextGraphics();
        tg.putString(0, 0, "LEVEL " + level);
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
