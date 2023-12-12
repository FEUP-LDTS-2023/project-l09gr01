package com.l09gr01.badice.gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.util.HashMap;
import java.util.Map;

public class KeybindManager {
    private static Map<GUI.ACTION, KeyStroke> keybinds;
    private static Map<GUI.ACTION, Character> characterKeybinds;

    private static boolean characterInputMode;
    private static boolean isIngame;

    public KeybindManager() {
        keybinds = new HashMap<>();
        characterKeybinds = new HashMap<>();

        keybinds.put(GUI.ACTION.MOVE_UP, new KeyStroke(KeyType.ArrowUp));
        keybinds.put(GUI.ACTION.MOVE_RIGHT, new KeyStroke(KeyType.ArrowRight));
        keybinds.put(GUI.ACTION.MOVE_DOWN, new KeyStroke(KeyType.ArrowDown));
        keybinds.put(GUI.ACTION.MOVE_LEFT, new KeyStroke(KeyType.ArrowLeft));
        characterKeybinds.put(GUI.ACTION.P2UP,'w');
        characterKeybinds.put(GUI.ACTION.P2DOWN, 's');
        characterKeybinds.put(GUI.ACTION.P2LEFT, 'a');
        characterKeybinds.put(GUI.ACTION.P2RIGHT,'d');
        characterKeybinds.put(GUI.ACTION.ACTION, ' ');
        keybinds.put(GUI.ACTION.P2ACTION, new KeyStroke(KeyType.Tab));
    }

    public static KeyStroke getKeybind(GUI.ACTION action) {
        return keybinds.get(action);
    }
    public static String getKeyString(GUI.ACTION action){
        if ((getCharacterKeybind(action) != null) && (getCharacterKeybind(action) == ' ')) return "SPACEBAR";
        return (getKeybind(action) != null && getKeybind(action).getKeyType() != KeyType.Character) ? getKeybind(action).getKeyType().toString() : getCharacterKeybind(action).toString();
    }

    public static void setKeybind(GUI.ACTION action, KeyStroke newKeyStroke) {
        keybinds.put(action, newKeyStroke);
        if (newKeyStroke.getKeyType() == KeyType.Character) {
            characterKeybinds.put(action, newKeyStroke.getCharacter());
        }
    }

    public static Character getCharacterKeybind(GUI.ACTION action) {
        return characterKeybinds.get(action);
    }

    public static void setCharacterInputMode(boolean characterInputMode) {
        KeybindManager.characterInputMode = characterInputMode;
    }

    public boolean isCharacterInputMode() {
        return characterInputMode;
    }

    public static void setIngame(boolean isIngame) {
        KeybindManager.isIngame = isIngame;
    }

    public static boolean isIngame() {
        return isIngame;
    }
}
