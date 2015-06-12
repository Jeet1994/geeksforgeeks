package org.shekhar.geeksforgeeks.snake_and_ladder;

public class Game {

    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void turn(int numberOnDie) {
        int userPosition = userPosition();
        if (userPosition > 0) {
            board.reinitializeBoard();
        }
        int currentUserPosition = userPosition + numberOnDie;
        if(board.isLadderAt(currentUserPosition)){
            currentUserPosition = board.getLadderAt(currentUserPosition).getEnd();
        }
        UserPositionTuple tuple = new UserPositionTuple(currentUserPosition);
        board.setUserPosition(tuple);
    }

    public int userPosition() {
        return board.userPosition();
    }

    public GameStatus status() {
        int userPosition = userPosition();
        if (userPosition < 100) {
            return GameStatus.IN_PROGRESS;
        }
        return GameStatus.FINISHED;
    }

}
