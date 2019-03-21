package com.github.wojtechm.settings;

import java.util.MissingResourceException;

/**
 * @author Makiela Wojciech
 */
public class DefaultSettingsUpdate extends SettingsUpdate {

    public DefaultSettingsUpdate(TranslationLoader translationLoader) {
        super(translationLoader);
    }

    @Override
    public void loadTranslation(String requestedTranslation) {
        try {
            Translation translation = translationLoader.loadTranslation(requestedTranslation);
            Settings.getInstance().setTranslation(translation);
        } catch (MissingResourceException e) {
            // TODO - Add communicate about nonexistent translation
        }
    }

    @Override
    public boolean updateGameParameter(String parameter, String newValue) {
        try {
            Settings.getInstance().setGameParameter(parameter, newValue);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
