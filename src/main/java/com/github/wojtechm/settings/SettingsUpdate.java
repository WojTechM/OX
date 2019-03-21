package com.github.wojtechm.settings;

/**
 * Gateway allowing modification of Settings {@link com.github.wojtechm.settings.Settings}
 * @author Makiela Wojciech
 */
public abstract class SettingsUpdate {

    TranslationLoader translationLoader;

    SettingsUpdate(TranslationLoader translationLoader) {
        this.translationLoader = translationLoader;
    }

    /**
     * Update language version currently used.
     *
     * @param translation requested translation
     */
    public abstract void loadTranslation(String translation);

    /**
     * Update game parameter if possible
     *
     * @param parameter name of parameter to change (eg. boardWidth)
     * @param newValue value for parameter
     * @return true, if update was successful, false otherwise
     */
    public abstract boolean updateGameParameter(String parameter, String newValue);
}
