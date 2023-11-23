package com.l09gr01.badice.controller;

import com.l09gr01.badice.GUI.GUI;
import com.l09gr01.badice.Game;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;
}
