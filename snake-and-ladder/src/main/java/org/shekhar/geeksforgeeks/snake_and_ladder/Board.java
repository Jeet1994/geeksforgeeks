package org.shekhar.geeksforgeeks.snake_and_ladder;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Board {

    private final Snake[] snakes;
    private final Ladder[] ladders;
    private final int rows;
    private final int cols;
    private int[][] board;

    private Board(Ladder[] ladders, Snake[] snakes, int rows, int cols) {
        this.board = new int[rows][rows];
        this.ladders = ladders;
        this.snakes = snakes;
        this.rows = rows;
        this.cols = cols;
    }


    public static Board emptyBoard() {
        return new Board(new Ladder[0], new Snake[0], 10, 10);
    }

    public static Board newBoardWithLadders(Ladder... ladders) {
        return new Board(ladders, new Snake[0], 10, 10);
    }

    public static Board newBoardWithLaddersAndSnakes(Ladder[] ladders, Snake[] snakes, int rows, int cols) {
        return new Board(ladders, snakes, rows, cols);
    }

    public void setUserPosition(UserPositionTuple tuple) {
        board[tuple.getFirst()][tuple.getSecond()] = 1;
    }

    public void reinitializeBoard() {
        board = new int[rows][cols];
    }

    public int userPosition() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    return rows * i + (j + 1);
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

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public Ladder findNearestLadder(int userPosition) {
        return Arrays.stream(ladders).filter(ladder -> ladder.getStart() > userPosition).findFirst().orElseGet(() -> null);
    }

    public int findNextPosition(int userPosition) {
        int end = userPosition + 6 > rows * cols ? rows * cols : userPosition + 6;
        return IntStream.rangeClosed(userPosition, end).filter(pos -> !isSnakeAt(pos)).max().getAsInt();
    }
}
