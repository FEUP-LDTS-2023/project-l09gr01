package com.l09gr01.badice.gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.*;

public class KeybindManager {
    private static final HashMap<GUI.ACTION, KeyStroke> keybinds = new HashMap<>();
    private static final HashMap<GUI.ACTION, Character> characterKeybinds= new HashMap<>();

    private static final List<GUI.ACTION> editableActions = Arrays.asList(
            GUI.ACTION.MOVE_UP, GUI.ACTION.MOVE_DOWN, GUI.ACTION.MOVE_LEFT, GUI.ACTION.MOVE_RIGHT,
            GUI.ACTION.P1ACTION, GUI.ACTION.P2UP, GUI.ACTION.P2DOWN, GUI.ACTION.P2LEFT,
            GUI.ACTION.P2RIGHT, GUI.ACTION.P2ACTION
    );
    private static boolean characterInputMode;
    private static boolean isIngame;

    public KeybindManager() {
        keybinds.put(GUI.ACTION.MOVE_UP, new KeyStroke(KeyType.ArrowUp));
        keybinds.put(GUI.ACTION.MOVE_RIGHT, new KeyStroke(KeyType.ArrowRight));
        keybinds.put(GUI.ACTION.MOVE_DOWN, new KeyStroke(KeyType.ArrowDown));
        keybinds.put(GUI.ACTION.MOVE_LEFT, new KeyStroke(KeyType.ArrowLeft));
        characterKeybinds.put(GUI.ACTION.P2UP,'W');
        characterKeybinds.put(GUI.ACTION.P2DOWN, 'S');
        characterKeybinds.put(GUI.ACTION.P2LEFT, 'A');
        characterKeybinds.put(GUI.ACTION.P2RIGHT,'D');
        characterKeybinds.put(GUI.ACTION.P1ACTION, ' ');
        keybinds.put(GUI.ACTION.P2ACTION, new KeyStroke(KeyType.Tab));
    }

    public static KeyStroke getKeybind(GUI.ACTION action) {
        return keybinds.get(action);
    }
    public static String getKeyString(GUI.ACTION action){
        if ((getKeybind(action) == null) && (getCharacterKeybind(action) == null)) return "NOT ASSIGNED";
        if ((getCharacterKeybind(action) != null) && (getCharacterKeybind(action) == ' ')) return "SPACEBAR";
        if (getKeybind(action) != null) return getKeybind(action).getKeyType().toString().toUpperCase(Locale.getDefault());
        else return getCharacterKeybind(action).toString().toUpperCase(Locale.getDefault());
    }

    public static void setKeybind(GUI.ACTION action, KeyStroke newKeyStroke) {
        if (newKeyStroke.getKeyType() == KeyType.Character) {
            Character newChar = Character.toUpperCase(newKeyStroke.getCharacter());
            keybinds.put(action,null);
            characterKeybinds.entrySet().removeIf(actionCharacterEntry -> newChar.equals(actionCharacterEntry.getValue()));
            characterKeybinds.put(action, newChar);
        } else {
            characterKeybinds.put(action,null);
            keybinds.entrySet().removeIf(actionKeyStrokeEntry -> newKeyStroke.equals(actionKeyStrokeEntry.getValue()));
            keybinds.put(action, newKeyStroke);
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

    public static GUI.ACTION getEditableAction(int i) {
        return editableActions.get(i);
    }
}
