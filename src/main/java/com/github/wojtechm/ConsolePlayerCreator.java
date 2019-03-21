package com.github.wojtechm;

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
        return new Players(new Player(new Field<>('o'), new Score(0), name1), new Player(new Field<>('x'), new Score(0), name2));
    }
}
