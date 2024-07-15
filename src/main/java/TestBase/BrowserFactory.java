package TestBase;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class BrowserFactory {
    public WebDriver createBrowserInstance( String browser ) throws Exception {
        String executionType = EnvironmentProperties.getEnvironmentProperties( "execution" );
        boolean headlessMode = Boolean.parseBoolean( EnvironmentProperties.getEnvironmentProperties( "headless" ) );
        WebDriver driver = null;
        if ( executionType.equalsIgnoreCase( "local" ) ) {
            System.setProperty("webdriver.chrome.silenOutput","true" );
            if ( browser.equalsIgnoreCase( "Edge" ) ) {
                driver = new InternetExplorerDriver();
            } else if ( browser.equalsIgnoreCase( "Firefox" ) ) {
                driver = new FirefoxDriver();
            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver = headlessMode?new ChromeDriver(options): new ChromeDriver();
            }
        } else if ( executionType.equalsIgnoreCase( "browserstack" ) ) {
            String browserstackUserName = EnvironmentProperties.getEnvironmentProperties( "browserstack.username" );
            String browserstackAccessKey = EnvironmentProperties.getEnvironmentProperties( "browserstack.accessKey" );
            String URL = "https://" + browserstackUserName + ":" + browserstackAccessKey + "@hub.browserstack.com/wd/hub/";
            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
            bstackOptions.put("os", "Windows");
            bstackOptions.put("osVersion", "11");
            bstackOptions.put("browserVersion", "latest");
            bstackOptions.put("consoleLogs", "info");
            bstackOptions.put("seleniumVersion", "4.21.0");
            bstackOptions.put("buildName", "Test");
            capabilities.setCapability("bstack:options", bstackOptions);
            driver = new RemoteWebDriver( new URL( URL),capabilities);
        } else {
            System.out.println( "Please verify execution type" );
            System.exit( 0 );
        }

        return driver;
    }
}
