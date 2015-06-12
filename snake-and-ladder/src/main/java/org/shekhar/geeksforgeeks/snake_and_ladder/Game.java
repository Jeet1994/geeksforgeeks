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
        if (board.isLadderAt(currentUserPosition)) {
            currentUserPosition = board.getLadderAt(currentUserPosition).getEnd();
        }
        if (board.isSnakeAt(currentUserPosition)) {
            currentUserPosition = board.getSnakeAt(currentUserPosition).getTo();
        }
        UserPositionTuple tuple = new UserPositionTuple(currentUserPosition, board.rows());
        board.setUserPosition(tuple);
    }

    public int userPosition() {
        return board.userPosition();
    }

    public GameStatus status() {
        int userPosition = userPosition();
        if (userPosition < board.rows()) {
            return GameStatus.IN_PROGRESS;
        }
        return GameStatus.FINISHED;
    }

    public int numberOfDieThrowsToFinish() {
        // At every position, find the ladder that would move user to the highest position with minimum throws
        // if there is no ladder with in 6 steps then move max points making sure you don't land on snake
        // if user reaches or crosses maximum cell then end
        int count = 0;
        int userPosition = 0;
        while (userPosition < (board.rows() * board.cols())) {
            Ladder ladder = board.findNearestLadder(userPosition);
            if (ladder != null) {
                userPosition = ladder.getEnd();
            } else {
                userPosition = board.findNextPosition(userPosition);
            }

            count++;
        }
        return count;
    }

}
