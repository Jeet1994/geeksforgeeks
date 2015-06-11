package org.shekhar.geeksforgeeks.snake_and_ladder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void givenGameBoardWithoutLaddersAndSnakes_WhenUserThrowsADieOnce_ThenUserPositionIsMovedByNumberOnDie() throws Exception {
        int[][] board = new int[10][10];
        int numberOnDie = 1;
        Game game = new Game(board);
        int userPosition = game.turn(numberOnDie);
        assertThat(userPosition, is(equalTo(1)));
    }

    @Test
    public void givenGameBoardWithoutLaddersAndSnakes_WhenUserThrowsDieMultipleTimes_ThenUserPositionIsSumOfAllDieNumbers() throws Exception {
        int[][] board = new int[10][10];
        Game game = new Game(board);
        game.turn(1);
        game.turn(5);
        int userPosition = game.turn(3);
        assertThat(userPosition, is(equalTo(9)));
    }
}
