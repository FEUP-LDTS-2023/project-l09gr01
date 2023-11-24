package com.l09gr01.badice.model.elements;

public class Wall extends Element{

    private int kind;

    public Wall(int x, int y)
    {
        super(x,y);
    }

    public void setKind(int kind)
    {
        this.kind = kind;
    }

    public int getKind()
    {
        return this.kind;
    }
}
