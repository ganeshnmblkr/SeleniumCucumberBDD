package TestBase;

import HelperClasses.CustomException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverHelper{
    public static void clearAndSendKeys(final WebDriver webDriver,final WebElement element,String text){
        new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element)).clear();
        element.click();
        element.sendKeys(text);
    }

    public static void click(final WebDriver webDriver,final WebElement element){
        try{
            element.click();
        } catch(Exception e){
            clickUsingJS(webDriver,element);
        }
    }

    public static void clickUsingJS(final WebDriver webDriver,final WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click()",element);
    }

    public static String readTextFromElement(final WebDriver webDriver,final WebElement element){
        return new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public static void scrollToTheElement(final WebDriver webDriver,final WebElement element){
        try{
            ((JavascriptExecutor) webDriver).executeScript("argument[0].scrollIntoView(true)",element);
        } catch(Exception e){
            throw new CustomException("Exception while scrolling to the element",e);
        }
    }
    public static void waitUntilElementIsClickable(final WebDriver driver,final WebDriver element,int timeOut){
    }
}
