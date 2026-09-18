package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public static String getData(String key) throws IOException {
        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Sauce_Data.Properties");
        Properties prop = new Properties();
        prop.load(fis);
        fis.close();
        return prop.getProperty(key);
    }
}