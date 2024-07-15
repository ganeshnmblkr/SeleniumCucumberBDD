package TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverHelper {
    public static void clearAndSendKeys( final WebDriver webDriver, final WebElement element,String text ){
        new WebDriverWait( webDriver, Duration.ofSeconds(20)).until( ExpectedConditions.visibilityOf( element )).clear();
        element.click();
        element.sendKeys( text );
    }
    public static void click(final WebDriver webDriver, final WebElement element){
        try {
            element.click();
        }catch (Exception e){
            clickUsingJS(webDriver,element);
        }
    }
    public static void clickUsingJS(final WebDriver webDriver, final WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) webDriver;
        js.executeScript( "arguments[0].click()",element );
    }
}
