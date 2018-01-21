package com.belykh.finalProj.manager;

import java.util.ResourceBundle;

/**
 * Created by panda on 6.12.17.
 */
public class ConfigurationManager {
    private final static ResourceBundle BUNDLE = ResourceBundle.getBundle("config");

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return BUNDLE.getString(key);

    }
}
