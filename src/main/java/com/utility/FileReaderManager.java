package com.utility;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderManager {

    private static FileInputStream fileInputStream;
    private static Properties property;

    public static void setupProperty() {
        File file = new File("src/main/resources/TestData.properties");
        try {
            fileInputStream = new FileInputStream(file);
            property = new Properties();
            property.load(fileInputStream);
        } catch (FileNotFoundException e) {
            Assert.fail("ERROR OCCUR DURING FILE LOADING");
        } catch (IOException e) {
            Assert.fail("ERROR OCCUR DURING FILE READING");
        }
    }

    public static String getDataProperty(String value) {
        setupProperty();
        String data = property.getProperty(value);
        return data;
    }
}