package org.shekhar.geeksforgeeks.snake_and_ladder;

public class Ladder {


    private final int start;
    private final int end;

    private Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Ladder from(int start, int end) {
        return new Ladder(start, end);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
