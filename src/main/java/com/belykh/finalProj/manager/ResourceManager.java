package com.belykh.finalProj.manager;

import java.util.Locale;
import java.util.ResourceBundle;

// TODO: Auto-generated Javadoc
/**
 * The Enum ResourceManager.
 */
public enum ResourceManager {
    
    /** The instance. */
    INSTANCE;

    private ResourceBundle resourceManager;
    private final String BUNDLE_PATH = "text";

    private ResourceManager() {
        resourceManager = ResourceBundle.getBundle(BUNDLE_PATH, Locale.getDefault());
    }

    /**
     * Change locale.
     *
     * @param locale the locale
     */
    public void changeLocale(Locale locale) {
        resourceManager = ResourceBundle.getBundle(BUNDLE_PATH, locale);
    }

    /**
     * Gets the property.
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(String key) {
        return resourceManager.getString(key);
    }
}
