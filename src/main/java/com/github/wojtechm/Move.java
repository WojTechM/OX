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

    Field getMark() {
        return mark;
    }

    Point getPosition() {
        return position;
    }
}
