package com.github.wojtechm;

import java.util.Objects;

/**
 * @author Makiela Wojciech
 */
class Score implements Comparable<Score>{

    final int points;

    Score(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return points == score.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Score{" +
                "points=" + points +
                '}';
    }

    @Override
    public int compareTo(Score o) {
        return points - o.points;
    }

    Score increasePoints(int increase) {
        return new Score(points + increase);
    }
}
