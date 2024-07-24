package cucumberHooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class RunContext {
    public static Map<Integer, ScenarioContext> scenarioContextMap = new HashMap<>();

    public static WebElement getWebElement(WebDriver driver,String elementLocatorString){
        Field field=null;
        WebElement elementLocator=null;
        Object pageObject=getScenarioContext( driver ).getPageObject();
        try {
            field=pageObject.getClass().getField(elementLocatorString);
            elementLocator= (WebElement) field.get( pageObject );
        } catch (NoSuchFieldException e) {
            throw new RuntimeException( e );
        } catch (IllegalAccessException e) {
            throw new RuntimeException( e );
        }
        return elementLocator;
    }
    public static ScenarioContext getScenarioContext( WebDriver driver ){
        return scenarioContextMap.get( driver.hashCode() );
    }

}
