package com.github.wojtechm;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Makiela Wojciech
 */
public class BoardTest {

    private static Random random = new Random();

    @Test(invocationCount = 20)
    private void Should_ReturnTrue_When_BoardsAreEquals_Otherwise_False() {
        Field[][] fields = getRandomBoardFields();
        Board board = new Board(fields);
        Board board2 = new Board(fields);
        assert board.equals(board2) : String.format("\nCompared boards using equals: \nB1{%s} \nB2{%s} \nExpected true, got false", board, board2);
        fields[0][0] = new Field<>('C');
        board = new Board(getRandomBoardFields());
        assert !board.equals(board2) : String.format("\nCompared boards using equals: \nB1{%s} \nB2{%s} \nExpected false, got true", board, board2);
    }

    private Field[][] getRandomBoardFields() {
        return new Field[3 + random.nextInt(1000)][3 + random.nextInt(1000)];
    }

    @Test(invocationCount = 20)
    private void Should_ReturnFieldObject_When_CalledGetMarkAtPoint() {
        Field[][] fields = getRandomBoardFields();
        int width = fields.length;
        int height = fields[0].length;
        Board board = new Board(fields);
        Point point = new Point(random.nextInt(width), random.nextInt(height));
        assert board.getMarkAtPoint(point) == null;
        Field<Character> mark = new Field<>('C');
        fields[point.x][point.y] = mark;
        assert board.getMarkAtPoint(point) == mark;
    }

    @Test(invocationCount = 20)
    private void Should_ChangeObjectInMatrix_When_CalledMarkPoint() throws IllegalMoveException {
        Field[][] fields = getRandomBoardFields();
        int width = fields.length;
        int height = fields[0].length;
        Board board = new Board(fields);
        Point point = new Point(random.nextInt(width), random.nextInt(height));
        assert board.getMarkAtPoint(point) == null;
        Field<Character> mark = new Field<>('C');
        board.markPoint(point, mark);
        assert board.getMarkAtPoint(point) == mark;
    }

    @Test
    private void Should_ReturnStringRepresentation_When_CalledToStringMethod() throws IllegalMoveException {
        Field[][] fields = new Field[3][3];
        Board board = new Board(fields);
        String actual = board.toString();
        String expected = " | | |\n------\n | | |\n------\n | | |\n------\n";
        assert expected.equals(actual) : String.format("Expected:\n%s\nGot:\n%s", expected, actual);
        board.markPoint(new Point(0, 1), new Field<>("X"));
        actual = board.toString();
        expected = " | | |\n------\nX| | |\n------\n | | |\n------\n";
        assert expected.equals(actual) : String.format("Expected:\n%s\nGot:\n%s", expected, actual);
        board.markPoint(new Point(1,0), new Field<>("O"));
        actual = board.toString();
        expected = " |O| |\n------\nX| | |\n------\n | | |\n------\n";
        assert expected.equals(actual) : String.format("Expected:\n%s\nGot:\n%s", expected, actual);
    }
}