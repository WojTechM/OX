package com.github.wojtechm.settings;

import java.util.ResourceBundle;

/**
 * @author Makiela Wojciech
 */
public class TranslationLoader {

    /**
     * Load and return new Translation
     * @param requestedTranslation name of translation to load
     * @return Translation with specified language, null otherwise
     */
    public Translation loadTranslation(String requestedTranslation) {
        ResourceBundle bundle = ResourceBundle.getBundle(requestedTranslation);
        return new Translation(bundle);
    }
}
