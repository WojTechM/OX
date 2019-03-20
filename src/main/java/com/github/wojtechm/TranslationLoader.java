package com.github.wojtechm;

import java.util.ResourceBundle;

/**
 * @author Makiela Wojciech
 */
class TranslationLoader {
    Translation loadTranslation(String requestedTranslation) {
        ResourceBundle bundle = ResourceBundle.getBundle(requestedTranslation);
        return new Translation(bundle);
    }
}
