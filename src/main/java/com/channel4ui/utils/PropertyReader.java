package com.channel4ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {


    private static PropertyReader propertyFileReader;
    private static Properties properties;

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        if (propertyFileReader == null) {
            propertyFileReader = new PropertyReader();
            properties = new Properties();

        }
        return propertyFileReader;
    }

    public void loadPropertyFile(File file) throws IOException {
        InputStream input = new FileInputStream(file);
        properties.load(input);
    }

    public String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}
