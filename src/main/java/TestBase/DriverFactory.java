package TestBase;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory(){
    }
    @Getter
    private static DriverFactory instance = new DriverFactory();

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public synchronized WebDriver getDriver() {
//        System.out.println("Driver Instance "+driver.get());
        return this.driver.get();
    }

    public void setDriver( WebDriver driverParam ) {
        driver.set( driverParam );
    }

    public void closeBrowser() {
        System.out.println("Driver Instance "+driver.get());
        driver.get().quit();
        driver.remove();
    }
}
