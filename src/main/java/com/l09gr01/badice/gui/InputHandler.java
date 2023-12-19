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
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.utils.GameStats;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.EnumSet;

public class InputHandler implements GUI {

    private final KeybindManager keybindManager;
    private final Screen screen;
    private char lastInputCharacter;
    public InputHandler(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
        keybindManager = new KeybindManager();
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
        return terminalFactory.createTerminal();
    }
    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/badice_font.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }
    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.PAUSE;
        if(!KeybindManager.isIngame()) {
            if ((keyStroke.getKeyType() == KeyType.Character) && keybindManager.isCharacterInputMode()) {
                char inputChar = keyStroke.getCharacter();
                if (Character.isLetter(inputChar)) {
                    lastInputCharacter = inputChar;
                    return ACTION.INPUT_CHAR;
                }
            }
            if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
            if (keyStroke.getKeyType() == KeyType.Backspace) return ACTION.BACKSPACE;
            if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
            if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
            if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
            if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        }
        for (ACTION action : EnumSet.of(ACTION.MOVE_UP, ACTION.MOVE_DOWN, ACTION.MOVE_LEFT, ACTION.MOVE_RIGHT, ACTION.P1ACTION,
                ACTION.P2UP, ACTION.P2DOWN, ACTION.P2LEFT, ACTION.P2RIGHT, ACTION.P2ACTION)) {
            KeyStroke actionKeyStroke = KeybindManager.getKeybind(action);
            Character characterKeyStroke = KeybindManager.getCharacterKeybind(action);
            if (actionKeyStroke != null && actionKeyStroke.equals(keyStroke)) return action;
            else if (characterKeyStroke != null && (keyStroke.getKeyType() == KeyType.Character) && (Character.toUpperCase(keyStroke.getCharacter()) == characterKeyStroke)) return action;
        }

        return ACTION.NONE;
    }

    public char getLastInputCharacter() {
        return lastInputCharacter;
    }
    public KeyStroke getUserInput() throws IOException {
        return screen.readInput();
    }

    @Override
    public void drawUpPlayerCharacter(Position position) {
        drawCharacter(position.getX(), position.getY(), '%', "#90EE90");
    }
    @Override
    public void drawDownPlayerCharacter(Position position) {
        drawCharacter(position.getX(), position.getY(), '$', "#90EE90");
    }
    @Override
    public void drawLeftPlayerCharacter(Position position) {
        drawCharacter(position.getX(), position.getY(), '_', "#90EE90");
    }
    @Override
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
@Override
    public void drawFruit(Position position) { drawCharacter(position.getX(), position.getY(), '~', "#32A852");}
@Override
    public void drawFruitInIce(Position position) { drawCharacter(position.getX(), position.getY(), '@', "#ADD8E6");}
    @Override
    public void drawPowerUp(Position position)
    {
        drawCharacter(position.getX(), position.getY(),'*', "#FFA500");
    }
    @Override
    public void drawEasyMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), '|', "#FF007F");
    }
    @Override
    public void drawMediumMonster(Position position) { drawCharacter(position.getX(), position.getY(), '{',"#FF007F" );}
    @Override
    public void drawHardMonster(Position position) { drawCharacter(position.getX(),position.getY(), '}', "#FF007F");}
    @Override
    public void drawHeader(int level, int score, String time){
        TextGraphics tg = screen.newTextGraphics();
        tg.putString(0, 0, "LEVEL " + level);
        tg.putString(16, 0, "SCORE:" + score);
        tg.putString(34, 0, time);

    }
    @Override
    public void drawFooter(int p1Hp,int p2Hp, boolean isSelected2Players, int totalScore, int score, int level){
        TextGraphics tg = screen.newTextGraphics();
        int currentTotalScore = score + totalScore - GameStats.getLevelScore(level);
        if(isSelected2Players) tg.putString(37, 41, "2P");
        else tg.putString(37, 41, "1P");
        if(isSelected2Players) tg.putString(18, 41,"P1 HP:" + p1Hp + "  P2 HP:" + p2Hp);
        else tg.putString(30,41,"HP:" + p1Hp);
        tg.putString(0, 41, "TOTAL SCORE:" + currentTotalScore);

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
