package com.github.wojtechm;

import java.util.Arrays;

/**
 * @author Makiela Wojciech
 */
class Board {

    private Field[][] fields;

    Board(Field[][] fields) {
        this.fields = fields;
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

    Field getMarkAtPoint(Point point) {
        return fields[point.x][point.y];
    }

    void markPoint(Point point, Field mark) {
        fields[point.x][point.y] = mark;
    }
}
