package com.l09gr01.badice.model;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getUp() {
        return new Position(x, y - 1);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }

    public Position getRandomNeighbour() {
        int n = (int) (Math.random() * 4);
        return switch (n) {
            case 0 -> getUp();
            case 1 -> getRight();
            case 2 -> getDown();
            default -> getLeft();
        };
    }

    @Override   @SuppressWarnings("EqualsHashCode")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return x == position.x && y == position.y;
    }

}
