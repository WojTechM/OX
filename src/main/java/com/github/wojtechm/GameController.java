package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
abstract class GameController {
    //TODO extend docs

    PlayerCreator playerCreator;
    BoardCreator boardCreator;

    GameController(PlayerCreator playerCreator, BoardCreator boardCreator) {
        this.playerCreator = playerCreator;
        this.boardCreator = boardCreator;
    }

    abstract void play() throws GameInterruptedByUserException;
}
