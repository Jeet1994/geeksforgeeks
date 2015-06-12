package org.shekhar.geeksforgeeks.snake_and_ladder;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void createGame() {
        game = new Game(Board.emptyBoard());
    }

    @Test
    public void givenGameBoardWithoutLaddersAndSnakes_WhenUserThrowsADieOnce_ThenUserPositionIsMovedByNumberOnDie() throws Exception {
        int numberOnDie = 1;
        game.turn(numberOnDie);
        int userPosition = game.userPosition();
        assertThat(userPosition, is(equalTo(1)));
    }

    @Test
    public void givenGameBoardWithoutLaddersAndSnakes_WhenUserThrowsDieMultipleTimes_ThenUserPositionIsSumOfAllDieNumbers() throws Exception {
        game.turn(1);
        game.turn(5);
        game.turn(3);
        int userPosition = game.userPosition();
        assertThat(userPosition, is(equalTo(9)));
    }

    @Test
    public void givenGameBoardWithoutLaddersAndSnakes_WhenUserThrowsDieMultipleTimes_ThenGameStatusIsInProgress() throws Exception {
        game.turn(5);
        game.turn(5);
        game.turn(1);
        game.turn(5);

        int userPosition = game.userPosition();
        assertThat(userPosition, is(equalTo(16)));

        GameStatus status = game.status();
        assertThat(status, is(equalTo(GameStatus.IN_PROGRESS)));
    }

    @Test
    public void givenGameBoardWithoutLaddersAndSnakes_WhenUserThrowsDieMultipleTimesToReach100_ThenUserWins() throws Exception {
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        int userPosition = game.userPosition();
        assertThat(userPosition, is(equalTo(100)));

        GameStatus status = game.status();
        assertThat(status, is(equalTo(GameStatus.FINISHED)));
    }

    @Test
    public void givenGameBoardWithLadder_WhenUserThrowADieAndMoveToPositionWithLadder_ThenUserShouldClimbTheLadderToReachNextPosition() throws Exception {
        Board board = Board.newBoardWithLadders(Ladder.from(4, 24));
        Game game = new Game(board);

        game.turn(4);

        int userPosition = game.userPosition();

        assertThat(userPosition, is(equalTo(24)));
    }


    @Test
    public void givenGameBoardWithMultipleLadders_WhenUserThrowDieMultipleTimesAndMoveToPositionWithLadder_ThenUserShouldClimbTheLadder() throws Exception {
        Board board = Board.newBoardWithLadders(Ladder.from(4, 24), Ladder.from(8, 34), Ladder.from(44, 78), Ladder.from(72, 93));
        Game game = new Game(board);

        game.turn(4);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);

        int userPosition = game.userPosition();

        assertThat(userPosition, is(equalTo(78)));

    }

    @Test
    public void givenGameBoardWithLaddersAndSnakes_WhenUserThrowDieAndUserLandsOnSnake_ThenUserShouldBeMovedToLowerPosition() throws Exception {
        Ladder[] ladders = {Ladder.from(4, 24), Ladder.from(8, 34), Ladder.from(44, 78), Ladder.from(72, 93)};
        Snake[] snakes = {Snake.at(15, 5)};
        Board board = Board.newBoardWithLaddersAndSnakes(ladders, snakes, 10, 10);
        Game game = new Game(board);

        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);
        game.turn(5);

        int userPosition = game.userPosition();

        assertThat(userPosition, is(equalTo(5)));

    }

    /*
    * Board taken from http://www.geeksforgeeks.org/snake-ladder-problem-2/
     */
    @Test
    public void givenABoardWithLaddersAndSnakes_FindMinimumNumberOfDieThrowsToFinishTheGame() throws Exception {
        Ladder[] ladders = {Ladder.from(3, 22), Ladder.from(5, 8), Ladder.from(11, 26), Ladder.from(20, 29)};
        Snake[] snakes = {Snake.at(17, 4), Snake.at(19, 7), Snake.at(21, 9), Snake.at(27, 1)};
        Board board = Board.newBoardWithLaddersAndSnakes(ladders, snakes, 5, 6);
        Game game = new Game(board);

        int count = game.numberOfDieThrowsToFinish();
        assertThat(count, is(equalTo(3)));


    }
}
