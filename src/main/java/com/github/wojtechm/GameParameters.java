package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class GameParameters {

    private int boardWidth = 3;
    private int boardHeight = 3;
    private int inlineMatches = 3;
    private int numberOfRounds = 3;
    private String translation = "polski";

    String get(String parameter) {
        switch (parameter) {
            case "boardWidth":
                return String.valueOf(boardWidth);
            case "boardHeight":
                return String.valueOf(boardHeight);
            case "inlineMatches":
                return String.valueOf(inlineMatches);
            case "numberOfRounds":
                return String.valueOf(numberOfRounds);
            case "translation":
                return String.valueOf(translation);
        }
        throw new IllegalArgumentException("Game parameters do not have variable: " + parameter);
    }
}
