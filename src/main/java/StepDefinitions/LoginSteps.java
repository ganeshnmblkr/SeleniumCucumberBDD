package StepDefinitions;

import HelperClasses.CustomWaits;
import TestBase.DriverFactory;
import TestBase.DriverHelper;
import TestBase.TestConstants;
import cucumberHooks.CucumberHooks;
import cucumberHooks.RunContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps extends BaseSteps{
    private RunContext runContext;
    CustomWaits customWaits;
    public LoginSteps(RunContext runContext){
        this.runContext = runContext;
    }
    public LoginSteps(){
    }

    @Given("user wants to test first step")
    public void user_wants_to_test_first_step(){
        System.out.println("user is inside given stepdffdff");
        System.out.println("Ajay");
//        WebDriver driver= new ChromeDriver();
//        driver.get( "https://au.yahoo.com/" );
    }

    @When("^user runs file \"([\\w\\s&]+)\"$")
    public void user_runs_file(String scenarioName){
        System.out.println(scenarioName+" user runs file Driver Instance "+getDriver());
    }

    @Then("scenario should run successfully")
    public void scenario_should_run_successfully(){
        System.out.println("user is inside then step");
    }

    @Given("LoginPage Given")
    public void loginPageGiven(){
        System.out.println(" LoginPage Given Driver Instance "+getDriver());
    }

    @When("Login Page When")
    public void loginPageWhen(){
        System.out.println(" LoginPage When Driver Instance "+getDriver());
    }

    @Then("login Page Then")
    public void loginPageThen(){
        System.out.println(" LoginPage Then Driver Instance "+getDriver());
    }

    @And("^I set the \"([\\w\\s&]+)\" field to \"([\\w\\s&]+)\"$")
    public void enterTextIntoWebElement(String strFieldName,String strValueKey){
        String value = CucumberHooks.envConfig.readTestDataByKey(strValueKey);
        customWaits = new CustomWaits(runContext);
        customWaits.waitForElementToBeVisible(strFieldName);
        WebElement textField = RunContext.getWebElement(DriverFactory.getInstance().getDriver(),strFieldName);
        textField.clear();
        DriverHelper.clearAndSendKeys(DriverFactory.getInstance().getDriver(),textField,value);
    }

    @When("^I click the \"([\\w\\s&]+)\" (button|link|element|tab|tile|checkbox|label|radio button)$")
    public void ClickElement(String elementSelector,String elementType){
        String elementName=elementSelector+StringUtils.capitalize(elementType);
        customWaits = new CustomWaits(runContext);
        customWaits.waitForElementToBeVisible(elementName);
        WebElement element = RunContext.getWebElement(DriverFactory.getInstance().getDriver(),elementName);
        new WebDriverWait ( DriverFactory.getInstance().getDriver(), Duration.ofSeconds ( TestConstants.defaultTimeoutInSec))
                .withMessage ( "Element: "+elementName+" not visible after waiting for "+TestConstants.defaultTimeoutInSec+" secods")
                .until ( ExpectedConditions.elementToBeClickable (element));
        element.click();
    }
}

