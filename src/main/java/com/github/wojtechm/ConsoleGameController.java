package com.github.wojtechm;

import com.github.wojtechm.logger.Logger;
import com.github.wojtechm.settings.Settings;

/**
 * @author Makiela Wojciech
 */
class ConsoleGameController extends GameController {

    private ConsoleInputAcquirer inputAcquirer;
    private Players players = null;

    ConsoleGameController(PlayerCreator playerCreator, BoardCreator boardCreator, ConsoleInputAcquirer inputAcquirer, Players players) {
        super(playerCreator, boardCreator);
        this.inputAcquirer = inputAcquirer;
        this.players = players;
    }

    ConsoleGameController(PlayerCreator playerCreator, BoardCreator boardCreator, ConsoleInputAcquirer inputAcquirer) {
        super(playerCreator, boardCreator);
        this.inputAcquirer = inputAcquirer;
    }

    @Override
    void play() throws GameInterruptedByUserException {

        initializePlayers();

        int turns = Integer.valueOf(Settings.getInstance().getGameParameter("numberOfRounds"));

        while (turns > 0) {
            turns--;
            Board board = boardCreator.createBoard();
            Game game = new Game(board, players, new GameFinishedValidator());
            Logger.getInstance().display(String.format(Settings.getInstance().getMessage("nextMatch"), players.getCurrentPlayer().getName()));
            playMatch(board, game);
            players.nextTurn();
        }

        String message = Settings.getInstance().getMessage("endGame");
        Logger.getInstance().display(String.format(message, players.toString()));
    }

    private void initializePlayers() throws GameInterruptedByUserException {
        if (players == null) {
            players = playerCreator.createPlayers();
        }
        Logger.getInstance().display(Settings.getInstance().getMessage("whoIsFirstPlayer"));
        String goesFirst = inputAcquirer.getStringFromUser();
        players.setPlayerAsCurrent(goesFirst);
    }

    private void playMatch(Board board, Game game) throws GameInterruptedByUserException {
        while (true) {
            Player currentPlayer = players.getCurrentPlayer();
            Logger.getInstance().display(String.format(Settings.getInstance().getMessage("currentPlayerIs"), currentPlayer.getName()));
            Point point = inputAcquirer.getPointInRange(board.getWidth(), board.getHeight());
            Move move = new Move(players.getCurrentPlayer().mark, point);
            try {
                game.make(move);
            } catch (IllegalMoveException e) {
                String message = Settings.getInstance().getMessage("invalidMove");
                Logger.getInstance().display(String.format(message, players.getCurrentPlayer().getName()));
                continue;
            } catch (GameHasEndedException e) {
                if (e.getCurrentPlayer() != null) {
                    e.getCurrentPlayer().addPoints(3);
                    Logger.getInstance().display(
                            String.format(Settings.getInstance().getMessage("winningPlayer"), e.getCurrentPlayer().getName()));
                } else {
                    players.givePoints(1);
                    Logger.getInstance().display(Settings.getInstance().getMessage("drawMessage"));
                }
                game.nextTurn();
                break;
            }
            game.nextTurn();
        }
    }
}
