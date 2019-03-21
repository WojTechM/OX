package com.github.wojtechm;

import org.testng.annotations.Test;

/**
 * @author Makiela Wojciech
 */
public class GameFinishedValidatorTest {

    @Test
    public void should_returnTrue_When_moveIsWinning() {
        // arrange
        Field<String> x = new Field<>("x");
        Field[][] fields = new Field[][]{
                {x, null, null},
                {null, x, null},
                {null, null, x},
        };
        Board board = new Board(fields);
        GameFinishedValidator validator = new GameFinishedValidator();
        Move move = new Move(x, new Point(2, 2));
        // act
        boolean actual = validator.isMoveWinning(board, move);
        // assert
        assert actual : "Expected true";
    }
}