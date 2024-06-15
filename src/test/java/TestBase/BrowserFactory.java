package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
    public WebDriver createBrowserInstance(String browser){
        WebDriver driver=null;
        if ( browser.equalsIgnoreCase( "Edge" ) ){
            driver=new InternetExplorerDriver();
        }else if ( browser.equalsIgnoreCase( "Firefox" ) ){
            driver=new FirefoxDriver();
        }else {
            driver= new ChromeDriver();
        }
        return driver;
    }
}
