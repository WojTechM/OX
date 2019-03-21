package com.github.wojtechm;

import com.github.wojtechm.logger.Logger;
import com.github.wojtechm.settings.Settings;

/**
 * @author Makiela Wojciech
 */
class ConsolePlayerCreator implements PlayerCreator {

    private ConsoleInputAcquirer inputAcquirer;

    ConsolePlayerCreator(ConsoleInputAcquirer inputAcquirer) {
        this.inputAcquirer = inputAcquirer;
    }

    @Override
    public Players createPlayers() throws GameInterruptedByUserException {
        Logger.getInstance().display(String.format(Settings.getInstance().getMessage("askForPlayerName"), "O"));
        String name1 = inputAcquirer.getStringFromUser();
        Logger.getInstance().display(String.format(Settings.getInstance().getMessage("askForPlayerName"), "X"));
        String name2 = inputAcquirer.getStringFromUser();
        return new Players(new Player(new Field<>('O'), new Score(0), name1), new Player(new Field<>('X'), new Score(0), name2));
    }
}
