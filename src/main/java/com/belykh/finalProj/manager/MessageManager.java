package com.belykh.finalProj.manager;

import java.util.Locale;
import java.util.ResourceBundle;

// TODO: Auto-generated Javadoc
/**
 * The Enum MessageManager.
 */
public enum MessageManager {
    
    /** The instance. */
    INSTANCE;

    private ResourceBundle messageManager;
    private final String BUNDLE_PATH = "messages";

    private MessageManager() {
        messageManager = ResourceBundle.getBundle(BUNDLE_PATH, Locale.getDefault());
    }

    /**
     * Change locale.
     *
     * @param locale the locale
     */
    public void changeLocale(Locale locale) {
        messageManager = ResourceBundle.getBundle(BUNDLE_PATH, locale);
    }

    /**
     * Gets the property.
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(String key) {
        return messageManager.getString(key);
    }
}
