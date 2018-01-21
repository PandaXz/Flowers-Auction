package com.belykh.finalProj.manager;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by panda on 4.12.17.
 */
public enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceManager;
    private final String BUNDLE_PATH = "text";

    private ResourceManager() {
        resourceManager = ResourceBundle.getBundle(BUNDLE_PATH, Locale.getDefault());
    }

    public void changeLocale(Locale locale) {
        resourceManager = ResourceBundle.getBundle(BUNDLE_PATH, locale);
    }

    public String getProperty(String key) {
        return resourceManager.getString(key);
    }
}
