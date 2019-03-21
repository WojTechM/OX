package com.github.wojtechm;

import com.github.wojtechm.settings.SettingsUpdate;

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
