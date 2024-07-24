package HelperClasses;

import TestBase.DriverFactory;
import TestBase.DriverHelper;
import TestBase.TestConstants;
import cucumberHooks.RunContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWaits  {

    private RunContext runContext;
    public CustomWaits(RunContext runContext){
        this.runContext=runContext;
    }

    public boolean waitForElementToBeVisible(String strFieldName){
        try{
        new WebDriverWait ( DriverFactory.getInstance().getDriver(), Duration.ofSeconds ( TestConstants.defaultTimeoutInSec))
                .withMessage ( "Element: "+strFieldName+" not visible after waiting for "+TestConstants.defaultTimeoutInSec+" secods")
                .until ( ExpectedConditions.visibilityOf ( RunContext.getWebElement ( DriverFactory.getInstance ().getDriver() ,strFieldName)));
        return true;
        }catch (Exception e){
            e.printStackTrace ();
            Assert.fail ();
            return  false;
        }
    }

//    public static void scrollToElement(final WebDriver webDriver,final ){
//                DriverHelper.scrollToTheElement (DriverFactory.getInstance().getDriver(),
//                RunContext.getWebElement (DriverFactory.getInstance().getDriver(),strFieldName));
//
//    }
}
