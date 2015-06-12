package org.shekhar.geeksforgeeks.snake_and_ladder;

import java.util.Arrays;

public class Board {

    private final Snake[] snakes;
    private final Ladder[] ladders;
    private int[][] board;

    private Board(Ladder[] ladders, Snake[] snakes) {
        this.board = new int[10][10];
        this.ladders = ladders;
        this.snakes = snakes;
    }


    public static Board emptyBoard() {
        return new Board(new Ladder[0], new Snake[0]);
    }

    public static Board newBoardWithLadders(Ladder... ladders) {
        return new Board(ladders, new Snake[0]);
    }

    public static Board newBoardWithLaddersAndSnakes(Ladder[] ladders, Snake[] snakes) {
        return new Board(ladders, snakes);
    }

    public void setUserPosition(UserPositionTuple tuple) {
        board[tuple.getFirst()][tuple.getSecond()] = 1;
    }

    public void reinitializeBoard() {
        board = new int[10][10];
    }

    public int userPosition() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    return 10 * i + (j + 1);
                }
            }
        }
        return 0;
    }


    public boolean isLadderAt(int userPosition) {
        return Arrays.stream(ladders).anyMatch(ladder -> ladder.getStart() == userPosition);
    }

    public Ladder getLadderAt(int userPosition) {
        return Arrays.stream(ladders).filter(ladder -> ladder.getStart() == userPosition).findFirst().get();
    }

    public boolean isSnakeAt(int userPosition) {
        return Arrays.stream(snakes).anyMatch(snake -> snake.getAt() == userPosition);
    }

    public Snake getSnakeAt(int userPosition) {
        return Arrays.stream(snakes).filter(snake -> snake.getAt() == userPosition).findFirst().get();
    }
}
