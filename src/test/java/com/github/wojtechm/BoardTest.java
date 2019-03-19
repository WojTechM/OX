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
        Field mark = new Field<>('C');
        fields[point.x][point.y] = mark;
        assert board.getMarkAtPoint(point) == mark;
    }

    @Test(invocationCount = 20)
    private void Should_ChangeObjectInMatrix_When_CalledMarkPoint() {
        Field[][] fields = getRandomBoardFields();
        int width = fields.length;
        int height = fields[0].length;
        Board board = new Board(fields);
        Point point = new Point(random.nextInt(width), random.nextInt(height));
        assert board.getMarkAtPoint(point) == null;
        Field mark = new Field<>('C');
        board.markPoint(point, mark);
        assert board.getMarkAtPoint(point) == mark;
    }



}