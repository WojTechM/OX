package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class GameFinishedValidator {

    boolean isGameOver(Board board) {
        return board.getWidth() * board.getHeight() == board.getPlacedMarks();
    }

    private enum Direction {
        TOP, DOWN, LEFT, RIGHT, TOP_LEFT, TOP_RIGHT, DOWN_LEFT, DOWN_RIGHT
    }

    boolean isMoveWinning(Board board, Move move) {
        int requiredInLine = Integer.parseInt(Settings.getInstance().getGameParameter("inlineMatches"));

        return isWinningInLine(Direction.TOP, Direction.DOWN, board, move, requiredInLine) ||
                isWinningInLine(Direction.LEFT, Direction.RIGHT, board, move, requiredInLine) ||
                isWinningInLine(Direction.TOP_LEFT, Direction.DOWN_RIGHT, board, move, requiredInLine) ||
                isWinningInLine(Direction.TOP_RIGHT, Direction.DOWN_LEFT, board, move, requiredInLine);
    }

    private boolean isWinningInLine(Direction d1, Direction d2, Board board, Move move, int requiredInLine) {
        int i1 = getNumberOfMatchingFieldsInDirection(board, d1, move);
        int i2 = getNumberOfMatchingFieldsInDirection(board, d2, move);
        return i1 + i2 + 1 >= requiredInLine;
    }

    private int getNumberOfMatchingFieldsInDirection(Board board, Direction direction, Move move) {
        Point toCheck = move.getPosition();
        int inLine = -1;
        do {
            toCheck = nextPointInDirection(direction, toCheck);
            inLine++;
        } while (move.getMark().equals(board.getMarkAtPoint(toCheck)));
        return inLine;
    }

    private Point nextPointInDirection(Direction direction, Point point) {
        switch (direction) {
            case TOP:
                return new Point(point.x, point.y + 1);
            case DOWN:
                return new Point(point.x, point.y - 1);
            case LEFT:
                return new Point(point.x - 1, point.y);
            case RIGHT:
                return new Point(point.x + 1, point.y);
            case TOP_LEFT:
                return new Point(point.x - 1, point.y + 1);
            case DOWN_LEFT:
                return new Point(point.x - 1, point.y - 1);
            case TOP_RIGHT:
                return new Point(point.x + 1, point.y + 1);
            case DOWN_RIGHT:
                return new Point(point.x + 1, point.y - 1);
            default:
                return point;
        }
    }
}
