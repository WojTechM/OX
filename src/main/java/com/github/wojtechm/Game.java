package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
public class Game {

    private final Board board;
    private final Players players;
    private final GameFinishedValidator validator;

    public Game(Board board, Players players, GameFinishedValidator validator) {
        this.board = board;
        this.players = players;
        this.validator = validator;
    }

    void update(Move move) throws IllegalMoveException, GameHasEndedException {

        Field field = board.getMarkAtPoint(move.getPosition());
        if (field != null) {
            throw new IllegalMoveException();
        }
        board.markPoint(move.getPosition(), move.getMark());
        if (validator.gameHasEnded(board, move)) {
            throw new GameHasEndedException(getActivePlayer());
        }

        Logger.getInstance().display(board.toString());
    }

    Player getActivePlayer() {
        return players.getCurrentPlayer();
    }

    void nextTurn() {
        players.moveToNextPlayer();
    }
}
