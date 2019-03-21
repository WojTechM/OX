package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class Player {

    private final String name;
    final Field mark;
    private final Score score;

    Player(Field mark, Score score) {
        this.mark = mark;
        this.score = score;
        this.name = "default";
    }

    Player(Field mark, Score score, String name) {
        this.mark = mark;
        this.score = score;
        this.name = name;
    }

    void addPoints(int points) {
        score.increasePoints(points);
    }

    String getName() {
        return name;
    }

    int points() {
        return score.points;
    }
}
