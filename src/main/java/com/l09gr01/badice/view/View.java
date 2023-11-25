package com.l09gr01.badice.view;

import com.l09gr01.badice.GUI.GUI;

import java.io.IOException;

public abstract class View<T> {
    private final T model;

    public View(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui);
}
