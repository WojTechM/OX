package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class Move {

    private final Field mark;
    private final Point position;

    Move(Field mark, Point position) {
        this.mark = mark;
        this.position = position;
    }

    Move(String sign, int x, int y) {
        this(new Field<>(sign), new Point(x, y));
    }

    Field getMark() {
        return mark;
    }

    Point getPosition() {
        return position;
    }
}
