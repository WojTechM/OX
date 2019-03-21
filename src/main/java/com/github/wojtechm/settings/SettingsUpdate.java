package com.github.wojtechm.settings;

/**
 * @author Makiela Wojciech
 */
public abstract class SettingsUpdate {

    TranslationLoader translationLoader;

    SettingsUpdate(TranslationLoader translationLoader) {
        this.translationLoader = translationLoader;
    }

    public abstract void loadTranslation(String translation);

    public abstract boolean updateGameParameter(String parameter, String newValue);
}
