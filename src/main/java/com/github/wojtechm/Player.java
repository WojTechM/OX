package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class Player {

    final Field mark;
    private final Score score;

    Player(Field mark, Score score) {
        this.mark = mark;
        this.score = score;
    }

    void addPoints(int points) {
        score.increasePoints(points);
    }
}
