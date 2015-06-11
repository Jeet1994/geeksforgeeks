package org.shekhar.geeksforgeeks.snake_and_ladder;

public class Game {

    private final int[][] board;
    private int userLocation;

    public Game(int[][] board) {
        this.board = board;
    }


    public int turn(int numberOnDie) {
        return userLocation += numberOnDie;
    }
}
