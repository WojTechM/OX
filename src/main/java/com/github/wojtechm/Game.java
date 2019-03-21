package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class Game {

    private final Board board;
    private final Players players;
    private final GameFinishedValidator validator;

    Game(Board board, Players players, GameFinishedValidator validator) {
        this.board = board;
        this.players = players;
        this.validator = validator;
    }

    void make(Move move) throws IllegalMoveException, GameHasEndedException {

        Field field = board.getMarkAtPoint(move.getPosition());
        if (field != null) {
            throw new IllegalMoveException("Repeated move?");
        }
        board.markPoint(move.getPosition(), move.getMark());
        if (validator.isMoveWinning(board, move)) {
            throw new GameHasEndedException(getActivePlayer());
        }

        if (validator.isGameOver(board)) {
            throw new GameHasEndedException(null); // No winning player - Draw
        }

        Logger.getInstance().display(board.toString());
    }

    private Player getActivePlayer() {
        return players.getCurrentPlayer();
    }

    void nextTurn() {
        players.moveToNextPlayer();
    }
}
