package com.veeva.automation.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream is =
                     ConfigReader.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            properties.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
