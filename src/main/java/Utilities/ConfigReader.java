package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader configReader = new ConfigReader();

    private Properties properties;

    private final String filaPath = "src/test/resources/Config.properties";

    private ConfigReader(){

        File file = new File(filaPath);

        try {

            FileInputStream fis = new FileInputStream(file);

            properties = new Properties();

            properties.load(fis);

        }catch (Exception e){

           e.printStackTrace();
        }

    }

    public static ConfigReader getInstance(){

        return configReader;
    }

    public String getURL(){

        return properties.getProperty("url");
    }
}
