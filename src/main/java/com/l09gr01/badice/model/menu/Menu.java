package com.l09gr01.badice.model.menu;

import java.util.Arrays;
import java.util.List;

public abstract class Menu {
    protected List<String> entries;
    protected int currentEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
