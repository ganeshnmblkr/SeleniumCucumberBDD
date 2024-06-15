package TestBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver( WebDriver driverParam ) {
        driver.set( driverParam );
    }

    public void closeBrowser() {
        driver.get().close();
        driver.remove();
    }
}
