package com.belykh.finalProj.manager;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by panda on 4.12.17.
 */
public enum MessageManager {
    INSTANCE;

    private ResourceBundle messageManager;
    private final String BUNDLE_PATH = "messages";

    private MessageManager() {
        messageManager = ResourceBundle.getBundle(BUNDLE_PATH, Locale.getDefault());
    }

    public void changeLocale(Locale locale) {
        messageManager = ResourceBundle.getBundle(BUNDLE_PATH, locale);
    }

    public String getProperty(String key) {
        return messageManager.getString(key);
    }
}
