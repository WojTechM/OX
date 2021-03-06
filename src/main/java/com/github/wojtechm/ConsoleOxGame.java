package com.github.wojtechm;

import com.github.wojtechm.logger.Logger;
import com.github.wojtechm.settings.Settings;
import com.github.wojtechm.settings.SettingsUpdate;

/**
 * @author Makiela Wojciech
 */
class ConsoleOxGame extends OxGame {

    private ConsoleInputAcquirer inputAcquirer;

    ConsoleOxGame(SettingsUpdate settingsUpdate, GameController gameController, ConsoleInputAcquirer inputAcquirer) {
        super(settingsUpdate, gameController);
        this.inputAcquirer = inputAcquirer;
    }

    @Override
    void run() {
        boolean quit = false;
        while (!quit) {
            try {
                Logger.getInstance().display(Settings.getInstance().getMessage("mainMenu"));
                int input = inputAcquirer.getIntInRangeFromUser(1, 3);
                switch (input) {
                    case 1:
                        gameController.play();
                        break;
                    case 2:
                        askForSettingsUpdate();
                        break;
                    case 3:
                        quit = true;
                        break;
                    default:
                        Logger.getInstance().display(Settings.getInstance().getMessage("invalidInput"));
                }
            } catch (GameInterruptedByUserException e) {
                quit = true;
            }
        }
        Logger.getInstance().display(Settings.getInstance().getMessage("goodbye"));
    }

    private void askForSettingsUpdate() throws GameInterruptedByUserException {
        Logger.getInstance().display(Settings.getInstance().getMessage("updateMenu"));
        String message = Settings.getInstance().getMessage("optionsDisplay");
        String[] currentSettings = Settings.getInstance().gameParameters();
        Logger.getInstance().display(
                String.format(message, currentSettings[0], currentSettings[1], currentSettings[2], currentSettings[3], currentSettings[4])
        );

        int currInline = Integer.valueOf(Settings.getInstance().getGameParameter("inlineMatches"));
        int currWidth = Integer.valueOf(Settings.getInstance().getGameParameter("boardWidth"));
        int currHeight = Integer.valueOf(Settings.getInstance().getGameParameter("boardHeight"));

        int input = inputAcquirer.getIntInRangeFromUser(1, 5);
        switch (input) {
            case 1: // change boardWidth
                message = Settings.getInstance().getMessage("requireNumberInRange");
                Logger.getInstance().display(String.format(message, currInline, 100));
                int width = inputAcquirer.getIntInRangeFromUser(currInline, 100);
                settingsUpdate.updateGameParameter("boardWidth", String.valueOf(width));
                break;

            case 2: // change boardHeight
                message = Settings.getInstance().getMessage("requireNumberInRange");
                Logger.getInstance().display(String.format(message, currInline, 100));
                int height = inputAcquirer.getIntInRangeFromUser(currInline, 100);
                settingsUpdate.updateGameParameter("boardHeight", String.valueOf(height));
                break;

            case 3: // change inlineMatches
                message = Settings.getInstance().getMessage("requireNumberInRange");
                Logger.getInstance().display(String.format(message, 3, Math.min(currWidth, currHeight)));
                int inlineMatches = inputAcquirer.getIntInRangeFromUser(3, Math.min(currWidth, currHeight));
                settingsUpdate.updateGameParameter("inlineMatches", String.valueOf(inlineMatches));
                break;

            case 4: // change numberOfGames
                message = Settings.getInstance().getMessage("requireNumberInRange");
                Logger.getInstance().display(String.format(message, 3, 10));
                int numberOfGames = inputAcquirer.getIntInRangeFromUser(3, 10);
                settingsUpdate.updateGameParameter("numberOfGames", String.valueOf(numberOfGames));
                break;

            case 5: // change translation
                message = Settings.getInstance().getMessage("askForTranslation");
                Logger.getInstance().display(message);
                String translation = inputAcquirer.getStringFromUser();
                settingsUpdate.loadTranslation(translation);
                settingsUpdate.updateGameParameter("translation", translation);
                break;

            default:
                Logger.getInstance().display(Settings.getInstance().getMessage("invalidInput"));
        }
    }
}
