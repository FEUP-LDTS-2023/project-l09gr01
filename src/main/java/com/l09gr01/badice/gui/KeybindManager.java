package com.l09gr01.badice.gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeybindManager {
    private static HashMap<GUI.ACTION, KeyStroke> keybinds;
    private static HashMap<GUI.ACTION, Character> characterKeybinds;

    private static final List<GUI.ACTION> editableActions = Arrays.asList(
            GUI.ACTION.MOVE_UP, GUI.ACTION.MOVE_DOWN, GUI.ACTION.MOVE_LEFT, GUI.ACTION.MOVE_RIGHT,
            GUI.ACTION.ACTION, GUI.ACTION.P2UP, GUI.ACTION.P2DOWN, GUI.ACTION.P2LEFT,
            GUI.ACTION.P2RIGHT, GUI.ACTION.P2ACTION
    );
    private static boolean characterInputMode;
    private static boolean isIngame;

    public KeybindManager() {
        keybinds = new HashMap<>();
        characterKeybinds = new HashMap<>();

        keybinds.put(GUI.ACTION.MOVE_UP, new KeyStroke(KeyType.ArrowUp));
        keybinds.put(GUI.ACTION.MOVE_RIGHT, new KeyStroke(KeyType.ArrowRight));
        keybinds.put(GUI.ACTION.MOVE_DOWN, new KeyStroke(KeyType.ArrowDown));
        keybinds.put(GUI.ACTION.MOVE_LEFT, new KeyStroke(KeyType.ArrowLeft));
        characterKeybinds.put(GUI.ACTION.P2UP,'W');
        characterKeybinds.put(GUI.ACTION.P2DOWN, 'S');
        characterKeybinds.put(GUI.ACTION.P2LEFT, 'A');
        characterKeybinds.put(GUI.ACTION.P2RIGHT,'D');
        characterKeybinds.put(GUI.ACTION.ACTION, ' ');
        keybinds.put(GUI.ACTION.P2ACTION, new KeyStroke(KeyType.Tab));
    }

    public static KeyStroke getKeybind(GUI.ACTION action) {
        return keybinds.get(action);
    }
    public static String getKeyString(GUI.ACTION action){
        if ((getCharacterKeybind(action) != null) && (getCharacterKeybind(action) == ' ')) return "SPACEBAR";
        else if ((getKeybind(action) == null) && (getCharacterKeybind(action) == null)) return "NOT ASSIGNED";
        else return (getKeybind(action) != null) ?
                getKeybind(action).getKeyType().toString().toUpperCase() : getCharacterKeybind(action).toString().toUpperCase();
    }

    public static void setKeybind(GUI.ACTION action, KeyStroke newKeyStroke) {
        if (newKeyStroke.getKeyType() == KeyType.Character) {
            Character newChar = Character.toUpperCase(newKeyStroke.getCharacter());
            characterKeybinds.put(action, newChar);
            if (keybinds.containsValue(newKeyStroke)){
                for (Map.Entry<GUI.ACTION, KeyStroke> entry : keybinds.entrySet()) {
                    if (newKeyStroke.getKeyType() == entry.getValue().getKeyType()) keybinds.remove(entry.getKey());
                }
            }
        }
        else{
            keybinds.put(action, newKeyStroke);
            if ((newKeyStroke.getKeyType() == KeyType.Character) && (characterKeybinds.containsValue(Character.toUpperCase(newKeyStroke.getCharacter())))){
                for (Map.Entry<GUI.ACTION, Character> entry : characterKeybinds.entrySet()) {
                    if (Character.toUpperCase(newKeyStroke.getCharacter()) == entry.getValue()) characterKeybinds.remove(entry.getKey());
                }
            }
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
