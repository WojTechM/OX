package com.github.wojtechm.settings;

import java.util.ResourceBundle;

/**
 * @author Makiela Wojciech
 */
public class TranslationLoader {
    public Translation loadTranslation(String requestedTranslation) {
        ResourceBundle bundle = ResourceBundle.getBundle(requestedTranslation);
        return new Translation(bundle);
    }
}
