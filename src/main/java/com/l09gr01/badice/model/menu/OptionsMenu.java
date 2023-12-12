package com.l09gr01.badice.model.menu;

import java.util.Arrays;

public class OptionsMenu extends Menu {

    public OptionsMenu() {
        super();
        this.entries = Arrays.asList("2 PLAYER MODE","SET P1 MOVE UP","SET P1 MOVE DOWN","SET P1 MOVE LEFT","SET P1 MOVE RIGHT"
                ,"SET P1 ACTION", "SET P2 MOVE UP","SET P2 MOVE DOWN", "SET P2 MOVE LEFT",
                "SET P2 MOVE RIGHT", "SET P2 ACTION", "TOGGLE GAME SOUNDS", "TOGGLE MUSIC","BACK TO MAIN MENU");
    }

    public boolean isSelected2PlayerMode() {
        return isSelected(0);
    }
    public boolean isSelectedSetP1MoveUp() {
        return isSelected(1);
    }
    public boolean isSelectedSetP1MoveDown() {
        return isSelected(2);
    }
    public boolean isSelectedSetP1MoveLeft() {
        return isSelected(3);
    }
    public boolean isSelectedSetP1MoveRight() {
        return isSelected(4);
    }
    public boolean isSelectedP1Action() {
        return isSelected(5);
    }
    public boolean isSelectedSetP2MoveUp() {
        return isSelected(6);
    }
    public boolean isSelectedSetP2MoveDown() {
        return isSelected(7);
    }
    public boolean isSelectedSetP2MoveLeft() {
        return isSelected(8);
    }
    public boolean isSelectedSetP2MoveRight() {
        return isSelected(9);
    }
    public boolean isSelectedP2Action() {
        return isSelected(10);
    }
    public boolean isSelectedToggleSound() {
        return isSelected(11);
    }
    public boolean isSelectedToggleMusic() {
        return isSelected(12);
    }
    public boolean isSelectedMainMenu(){
        return isSelected(13);
    }


}
