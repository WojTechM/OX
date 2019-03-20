package com.github.wojtechm;

import java.util.MissingResourceException;

/**
 * @author Makiela Wojciech
 */
class ConsoleSettingsUpdate extends SettingsUpdate {

    ConsoleSettingsUpdate(TranslationLoader translationLoader) {
        super(translationLoader);
    }

    @Override
    void loadTranslation(String requestedTranslation) {
        try {
            Translation translation = translationLoader.loadTranslation(requestedTranslation);
            Settings.getInstance().setTranslation(translation);
        } catch (MissingResourceException e) {
            // TODO - Add communicate about nonexistent translation
        }
    }

    @Override
    boolean updateGameParameter(String parameter, String newValue) {
        try {
            Settings.getInstance().setGameParameter(parameter, newValue);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
