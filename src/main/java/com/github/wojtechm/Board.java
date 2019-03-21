package com.github.wojtechm;

import java.util.Arrays;

/**
 * @author Makiela Wojciech
 */
class Board {
    private Field[][] fields;

    private int placedMarks = 0;

    Board(Field[][] fields) {
        this.fields = fields;
    }

    int getHeight() {
        return fields[0].length;
    }

    int getWidth() {
        return fields.length;
    }

    int getPlacedMarks() {
        return placedMarks;
    }

    Field getMarkAtPoint(Point point) {
        if (point.x < 0 || point.x >= getWidth() || point.y < 0 || point.y >= getHeight()) {
            return null;
        }
        return fields[point.x][point.y];
    }

    void markPoint(Point point, Field mark) throws IllegalMoveException {
        if (point.x < 0 || point.x >= getWidth() || point.y < 0 || point.y >= getHeight()) {
            throw new IllegalMoveException("Outside of the board, please correct");
        }
        fields[point.x][point.y] = mark;
        placedMarks++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(fields, board.fields);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(fields);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < fields[0].length; y++) {
            for (Field[] field : fields) {
                if (field[y] == null) {
                    builder.append(" |");
                } else {
                    builder.append(field[y]);
                    builder.append("|");
                }
            }
            builder.append("\n");
            for (int i = 0; i < getWidth() * 2; i++) {
                builder.append("-");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
