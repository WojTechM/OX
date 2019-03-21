package com.github.wojtechm.settings;

import java.util.ResourceBundle;

/**
 * @author Makiela Wojciech
 */
class Translation {

    private final ResourceBundle bundle;

    Translation(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    String getMessage(String key) {
        return bundle.getString(key);
    }
}
