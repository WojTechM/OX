package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
abstract class GameController {

    PlayerCreator playerCreator;
    BoardCreator boardCreator;

    GameController(PlayerCreator playerCreator, BoardCreator boardCreator) {
        this.playerCreator = playerCreator;
        this.boardCreator = boardCreator;
    }

    abstract void play() throws GameInterruptedByUserException;
}
