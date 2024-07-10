package StepDefinitions;

import TestBase.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    public WebDriver getDriver(){
       return DriverFactory.getInstance().getDriver();
    }
}
