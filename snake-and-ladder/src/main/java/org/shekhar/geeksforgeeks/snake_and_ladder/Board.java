package org.shekhar.geeksforgeeks.snake_and_ladder;

public class Board {

    private Ladder ladder;
    private int[][] board;

    private Board() {
        this.board = new int[10][10];
    }

    private Board(Ladder ladder) {
        this();
        this.ladder = ladder;
    }

    public static Board newBoardWithLadder(Ladder ladder) {
        return new Board(ladder);
    }

    public static Board emptyBoard() {
        return new Board();
    }

    public void setUserPosition(UserPositionTuple tuple) {
        board[tuple.getFirst()][tuple.getSecond()] = 1;
    }

    public void reinitializeBoard() {
        board = new int[10][10];
    }

    public int userPosition(){
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
        if(ladder == null){
            return false;
        }
        return ladder.getStart() == userPosition;
    }

    public Ladder getLadderAt(int userPosition) {
        return ladder;
    }
}
