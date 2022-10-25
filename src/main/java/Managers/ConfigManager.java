package Managers;

import java.io.*;
import java.util.Properties;

public class ConfigManager {

    public static Properties readConfig() {

        FileInputStream fis;
        Properties prop = new Properties();

        try {
            String file = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config.properties";
            fis = new FileInputStream(file);
            try {
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return prop;
    }
}