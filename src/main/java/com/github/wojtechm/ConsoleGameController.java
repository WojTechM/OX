package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
class ConsoleGameController extends GameController {

    private ConsoleInputAcquirer inputAcquirer;

    ConsoleGameController(PlayerCreator playerCreator, BoardCreator boardCreator, ConsoleInputAcquirer inputAcquirer) {
        super(playerCreator, boardCreator);
        this.inputAcquirer = inputAcquirer;
    }

    @Override
    void play() {

        Players players = playerCreator.createPlayers();
        int turns = 3;

        while (turns > 0) {
            turns--;
            Board board = boardCreator.createBoard();
            Game game = new Game(board, players, new GameFinishedValidator());
            Logger.getInstance().display("New Turn! Player " + players.getCurrentPlayer().mark.toString() + " goes first!");
            while (true) {
                Point point = inputAcquirer.getPointInRange(board.getWidth(), board.getHeight());
                Move move = new Move(players.getCurrentPlayer().mark, point);
                try {
                    game.update(move);
                } catch (IllegalMoveException e) {
                    continue; // Same player goes again
                } catch (GameHasEndedException e) {
                    if (e.getCurrentPlayer() != null) {
                        e.getCurrentPlayer().addPoints(3);
                    } else {
                        players.givePoints(1);
                    }
                    break;
                }
                game.nextTurn();
            }

        }
    }
}
