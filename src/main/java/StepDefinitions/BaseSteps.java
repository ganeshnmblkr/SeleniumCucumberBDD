package StepDefinitions;

import TestBase.DriverFactory;
import cucumberHooks.RunContext;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class BaseSteps {
    public BaseSteps () {
    }

    public WebDriver getDriver(){
       return DriverFactory.getInstance().getDriver();
    }

    public void navigateToPage(String pageName){
        String pageObjectName= StringUtils.capitalize(pageName)+"Page";
        Class<?> classObject=null;
        try {
            classObject = Class.forName( "pageObject."+pageObjectName );
            RunContext.getScenarioContext( DriverFactory.getInstance().getDriver())
                    .setPageObject( classObject.getDeclaredConstructor( WebDriver.class ).
                            newInstance( DriverFactory.getInstance().getDriver() ));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException( e );
        } catch (InvocationTargetException e) {
            throw new RuntimeException( e );
        } catch (InstantiationException e) {
            throw new RuntimeException( e );
        } catch (IllegalAccessException e) {
            throw new RuntimeException( e );
        } catch (NoSuchMethodException e) {
            throw new RuntimeException( e );
        }
    }
}
