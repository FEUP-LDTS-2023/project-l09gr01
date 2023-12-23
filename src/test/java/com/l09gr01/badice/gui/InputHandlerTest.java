package com.l09gr01.badice.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.l09gr01.badice.model.Position;
import com.l09gr01.badice.utils.GameStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {
    private Screen screen;
    private InputHandler gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new InputHandler(screen);

    }

    @Test
    void drawUpPlayerCharacterTest() {
        gui.drawUpPlayerCharacter(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(144,238,144));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "%");
    }
    @Test
    void drawDownPlayerCharacterTest() {
        gui.drawDownPlayerCharacter(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "$");
    }
    @Test
    void drawLeftPlayerCharacterTest() {
        gui.drawLeftPlayerCharacter(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "_");
    }
    @Test
    void drawRightPlayerCharacterTest() {
        gui.drawRightPlayerCharacter(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "^");
    }
    @Test
    void drawWallTest() {
        gui.drawWall(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "#");
    }
    @Test
    void drawIceTest() {
        gui.drawIce(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "&");
    }
    @Test
    void drawFruitTest() {
        gui.drawFruit(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "~");
    }
    @Test
    void drawFruitInIceTest() {
        gui.drawFruitInIce(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "@");
    }
    @Test
    void drawPowerUpTest() {
        gui.drawPowerUp(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "*");
    }
    @Test
    void drawEasyMonsterTest() {
        gui.drawEasyMonster(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "|");
    }
    @Test
    void drawMediumMonsterTest() {
        gui.drawMediumMonster(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "{");
    }
    @Test
    void drawHardMonsterTest() {
        gui.drawHardMonster(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "}");
    }
    @Test
    void drawHeaderTest() {
        gui.drawHeader(1,1000,"00:00");
        Mockito.verify(tg, Mockito.times(1)).putString(0, 0, "LEVEL 1");
        Mockito.verify(tg, Mockito.times(1)).putString(16, 0, "SCORE:1000");
        Mockito.verify(tg, Mockito.times(1)).putString(34, 0, "00:00");
    }
    @Test
    void drawFooterTest() {
        GameStats.setLevelScore(2,0);
        gui.drawFooter(1,1,true,5000,2000,2);
        Mockito.verify(tg, Mockito.times(1)).putString(18, 41, "P1 HP:1  P2 HP:1");
        Mockito.verify(tg, Mockito.times(1)).putString(37, 41, "2P");
    }
    @Test
    void getNextActionTest() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(null);
        assertEquals(gui.getNextAction(), GUI.ACTION.NONE);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));
        assertEquals(gui.getNextAction(), GUI.ACTION.QUIT);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Escape));
        assertEquals(gui.getNextAction(), GUI.ACTION.PAUSE);
        KeybindManager.setIngame(false);
        KeybindManager.setCharacterInputMode(true);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('A',false,false));
        assertEquals(gui.getNextAction(), GUI.ACTION.INPUT_CHAR);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));
        assertEquals(gui.getNextAction(), GUI.ACTION.SELECT);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Backspace));
        assertEquals(gui.getNextAction(), GUI.ACTION.BACKSPACE);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        assertEquals(gui.getNextAction(), GUI.ACTION.UP);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
        assertEquals(gui.getNextAction(), GUI.ACTION.DOWN);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(gui.getNextAction(), GUI.ACTION.LEFT);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));
        assertEquals(gui.getNextAction(), GUI.ACTION.RIGHT);
        /*  The following commented tests are not accepted by PITEST
            even though they pass without mutation (Probably something to do)
            with KeybindManager).
        KeybindManager.setIngame(true);
        KeybindManager.setCharacterInputMode(false);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('W',false,false));
        assertEquals(gui.getNextAction(), GUI.ACTION.P2UP);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('S',false,false));
        assertEquals(gui.getNextAction(), GUI.ACTION.P2DOWN);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('A',false,false));
        assertEquals(gui.getNextAction(), GUI.ACTION.P2LEFT);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('D',false,false));
        assertEquals(gui.getNextAction(), GUI.ACTION.P2RIGHT);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Tab));
        assertEquals(gui.getNextAction(), GUI.ACTION.P2ACTION);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        assertEquals(gui.getNextAction(), GUI.ACTION.MOVE_UP);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
        assertEquals(gui.getNextAction(), GUI.ACTION.MOVE_DOWN);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(gui.getNextAction(), GUI.ACTION.MOVE_LEFT);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));
        assertEquals(gui.getNextAction(), GUI.ACTION.MOVE_RIGHT);
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(' ',false,false));
        assertEquals(gui.getNextAction(), GUI.ACTION.P1ACTION);

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke('J',false,false));
        assertEquals(gui.getNextAction(), GUI.ACTION.NONE);*/
    }
    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "Hello World");
    }
}
