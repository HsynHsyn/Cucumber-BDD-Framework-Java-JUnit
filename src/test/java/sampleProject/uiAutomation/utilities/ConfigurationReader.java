package sampleProject.uiAutomation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class provides methods to read and write properties from a configuration file. */

public class ConfigurationReader {

    private static Properties properties;

    /**
     * Static initializer block that loads the properties from the configuration file.*/
    static {
        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the value associated with the given key from the configuration properties.
     */
    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

    /**
     * Sets the value of the specified key in the configuration properties.*/
    public static void set(String keyName, String value) {
        properties.setProperty(keyName, value);
    }
}