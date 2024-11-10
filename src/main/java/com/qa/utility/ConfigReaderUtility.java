package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReaderUtility {

    private static ConfigReaderUtility configReader = new ConfigReaderUtility();

    private Properties properties;

    private static final String filaPath = "src/test/resources/config/config.properties";

    private ConfigReaderUtility(){

        File file = new File(filaPath);

        try {

            FileInputStream fis = new FileInputStream(file);

            properties = new Properties();

            properties.load(fis);

        }catch (Exception e){

           e.printStackTrace();
        }

    }

    public static ConfigReaderUtility getInstance(){

        return configReader;
    }

    public String getURL(){

        return properties.getProperty("url");
    }

    public String getBrowser(){

        return properties.getProperty("browser");
    }
}
