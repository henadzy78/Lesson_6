package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static Properties properties = null;
    private static String filename = "config.properties";

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream(filename));
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public static String getUrl() {return properties.getProperty("url");}
    public static String getBrowserType() {return properties.getProperty("BrowserType");}
    public static String getHeadless(){return properties.getProperty("Headless");}



}
