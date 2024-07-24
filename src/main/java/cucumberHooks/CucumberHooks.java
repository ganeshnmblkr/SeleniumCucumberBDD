package cucumberHooks;

import TestBase.BrowserFactory;
import TestBase.DriverFactory;
import TestBase.EnvironmentProperties;
import TestBase.environmentConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    BrowserFactory browserFactor = new BrowserFactory();
    public WebDriver driver=null;
    public static environmentConfig envConfig=new environmentConfig();
    @Before
    public void launchApplication( Scenario scenario ) throws Exception {
        envConfig.setEnvironmentDetails();
        envConfig.getTestData();
        ScenarioContext sc = new ScenarioContext();
        TestScenario testScenario = new TestScenario();
//        testScenario.setTestCaseID("");
        testScenario.setScenario( scenario.getName() );
        sc.setTestScenario( testScenario );
        String browser = EnvironmentProperties.getEnvironmentProperties("browser");
        String appURL =envConfig.getTestEnvURL();
        DriverFactory.getInstance().setDriver( browserFactor.createBrowserInstance( browser ) );
        driver = DriverFactory.getInstance().getDriver();
        RunContext.scenarioContextMap.put( driver.hashCode(),sc );
        driver.manage().window().maximize();
        driver.get(appURL);
    }
    @After
    public void tearDown() {
          RunContext.scenarioContextMap.remove(driver.hashCode());
          driver.quit();
//        DriverFactory.getInstance().closeBrowser();
        }
}

