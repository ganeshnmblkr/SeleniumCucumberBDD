package TestBase;

import java.io.FileInputStream;
import java.util.Properties;

public class EnvironmentProperties {

    static Properties prop = new Properties();

    public static String getEnvironmentProperties( String key ) throws Exception {
        String propertyFilePath = System.getProperty( "user.dir" ) + "/src/test/resources/config.properties";
        FileInputStream fis = new FileInputStream( propertyFilePath );
        prop.load( fis );
        return prop.get( key ).toString();
    }
}
