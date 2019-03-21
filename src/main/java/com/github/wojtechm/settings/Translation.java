package com.github.wojtechm.settings;

import java.util.ResourceBundle;

/**
 * @author Makiela Wojciech
 */
public class Translation {

    private final ResourceBundle bundle;

    public Translation(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public String getMessage(String key) {
        return bundle.getString(key);
    }
}
