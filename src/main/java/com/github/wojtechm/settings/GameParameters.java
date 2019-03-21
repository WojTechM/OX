package com.github.wojtechm.settings;

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
            default:
                throw new IllegalArgumentException("Game parameters do not have variable: " + parameter);
        }
    }

    void set(String parameter, String value) {
        switch (parameter) {
            case "boardWidth":
                boardWidth = Integer.parseInt(value);
                break;
            case "boardHeight":
                boardHeight = Integer.parseInt(value);
                break;

            case "inlineMatches":
                inlineMatches = Integer.parseInt(value);
                break;

            case "numberOfRounds":
                numberOfRounds = Integer.parseInt(value);
                break;

            case "translation":
                this.translation = value;
                break;
            default:
                throw new IllegalArgumentException("Game parameters do not have variable: " + parameter);
        }
    }
}
