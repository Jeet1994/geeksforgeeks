package org.shekhar.geeksforgeeks.snake_and_ladder;

public class Snake {

    private final int to;
    private final int at;

    private Snake(int at, int to) {
        this.at = at;
        this.to = to;
    }

    public static Snake at(int at, int to) {
        return new Snake(at,to);
    }

    public int getTo() {
        return to;
    }

    public int getAt() {
        return at;
    }
}
