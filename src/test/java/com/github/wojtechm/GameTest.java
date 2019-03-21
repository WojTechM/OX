package com.github.wojtechm;

import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Makiela Wojciech
 */
public class GameTest {


    private final GameFinishedValidator validator = new GameFinishedValidator();

    @Test
    void should_change_When_moveHappened() throws IllegalMoveException, GameHasEndedException {
        // arrange
        Board board1 = new Board(new Field[][]{{null, null}});
        Board board2 = new Board(new Field[][]{{null, null}});
        Game game = new Game(board1, null, validator);
        Move move = new Move(new Field<>("X"), new Point(0, 0));

        // act
        game.make(move);

        // assert
        assert !board1.equals(board2) : "Plansze są równe, pomimo ruchu";
    }

    @DataSupplier
    public Stream<Move> repeatedMovesData() {
        return IntStream.rangeClosed(1, 20).mapToObj(n -> new Move("x", n, n + 1));
    }

    @Test(expectedExceptions = IllegalMoveException.class, expectedExceptionsMessageRegExp = "Repeated move\\?", dataProvider = "repeatedMovesData")
    void should_throwIllegalMoveException_When_placedMarkOnSamePositionTwice(Move move) throws IllegalMoveException, GameHasEndedException {
        // arrange
        Board board = new Board(new Field[25][25]);
        Game game = new Game(board, null, validator);

        // act
        game.make(move);
        game.make(move);
    }
}