package GUI;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l09gr01.badice.GUI.InputHandler;
import com.l09gr01.badice.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class InputHandlerTest {

    private Screen screen;
    private InputHandler gui;

    private TextGraphics tg;

    @BeforeEach
    void setup()
    {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new InputHandler(screen);
    }

    @Test
    void drawHero()
    {
        gui.drawPlayerCharacter(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,215,0));
        Mockito.verify(tg, Mockito.times(1)).putString(1,2,"H");
    }
}
