package com.github.wojtechm;

/**
 * @author Makiela Wojciech
 */
abstract class SettingsUpdate {

    TranslationLoader translationLoader;

    SettingsUpdate(TranslationLoader translationLoader) {
        this.translationLoader = translationLoader;
    }

    abstract void loadTranslation(String translation);

    abstract boolean updateGameParameter(String parameter, String newValue);
}
