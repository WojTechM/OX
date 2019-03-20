package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class GameFinishedValidator {

    private enum Direction {
        TOP, DOWN, LEFT, RIGHT, TOP_LEFT, TOP_RIGHT, DOWN_LEFT, DOWN_RIGHT
    }

    boolean gameHasEnded(Board board, Move move) {
        int requiredInLine = Integer.parseInt(Settings.getInstance().getGameParameter("inlineMatches"));

        int top = getNumberOfMatchingFieldsInDirection(board, Direction.TOP, move);
        int down = getNumberOfMatchingFieldsInDirection(board, Direction.DOWN, move);
        if (top + down + 1 >= requiredInLine) {
            return true;
        }

        int left = getNumberOfMatchingFieldsInDirection(board, Direction.LEFT, move);
        int right = getNumberOfMatchingFieldsInDirection(board, Direction.RIGHT, move);
        if (left + right + 1 >= requiredInLine) {
            return true;
        }

        int topLeft = getNumberOfMatchingFieldsInDirection(board, Direction.TOP_LEFT, move);
        int downRight = getNumberOfMatchingFieldsInDirection(board, Direction.DOWN_RIGHT, move);
        if (topLeft + downRight + 1 >= requiredInLine) {
            return true;
        }

        int topRight = getNumberOfMatchingFieldsInDirection(board, Direction.TOP_RIGHT, move);
        int downLeft = getNumberOfMatchingFieldsInDirection(board, Direction.DOWN_LEFT, move);
        return topRight + downLeft + 1 >= requiredInLine;
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
