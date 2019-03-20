package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
abstract class OxGame {

    SettingsUpdate settingsUpdate;
    GameController gameController;

    OxGame(SettingsUpdate settingsUpdate, GameController gameController) {
        this.settingsUpdate = settingsUpdate;
        this.gameController = gameController;
    }

    abstract void run();
}
