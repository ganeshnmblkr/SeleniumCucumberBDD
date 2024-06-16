package cucumberHooks;

import TestBase.BrowserFactory;
import TestBase.DriverFactory;
import TestBase.EnvironmentProperties;
import TestBase.environmentConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    BrowserFactory browserFactor = new BrowserFactory();
    public WebDriver driver=null;
    public environmentConfig envConfig=new environmentConfig();
    @Before
    public void
    launchApplication() throws Exception {
        envConfig.setenvironmentDetails();
        String browser = EnvironmentProperties.getEnvironmentProperties("browser");
        String appURL =envConfig.getTestEnvURL();
        DriverFactory.getInstance().setDriver( browserFactor.createBrowserInstance( browser ) );
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        System.out.println("appURL:- "+appURL);
        driver.get(appURL);
    }
    @After
    public void tearDown() {
        DriverFactory.getInstance().closeBrowser();
        System.out.println("appURL:-Ganesh ");
    }
}

