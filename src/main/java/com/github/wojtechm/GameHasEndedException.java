package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class GameHasEndedException extends OXGameException {

    private Player currentPlayer;

    GameHasEndedException(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    Player getCurrentPlayer() {
        return currentPlayer;
    }
}
