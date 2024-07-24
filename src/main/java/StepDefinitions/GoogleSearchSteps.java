package StepDefinitions;

import TestBase.DriverFactory;
import cucumberHooks.CucumberHooks;
import cucumberHooks.RunContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;

public class GoogleSearchSteps extends BaseSteps {
    private RunContext runContext;

    public GoogleSearchSteps(RunContext runContext){
        this.runContext=runContext;
    }
    public GoogleSearchSteps(){
    }

    @Given("^I am the \"([\\w\\s&]+)\" Page$" )
    public void userNavigatesToPage(String pageName){
        navigateToPage ( pageName );
    }
    @Given("user opens browser")
    public void user_opens_browser() {
        System.out.println("Driver Instance user opens browser"+getDriver());
//        System.out.println(loginPage.validateLoginPageTitle());
//        System.out.println("Ganesh");
//        WebDriver driver = new ChromeDriver();
//        driver.get( "https://www.google.com/" );
    }

    @When("user type search")
    public void user_type_search() {
        System.out.println("Driver Instance user type search"+getDriver());
        System.out.println("Ganesh1");
    }

    @Then("user should get the result")
    public void user_should_get_the_result() {
        System.out.println("Driver Instance user should get the result"+getDriver());
        System.out.println("Ganesh1");
    }
    @Given( "^user logins to the application using \"([\\w\\s&]+)\" and \"([\\w\\s&]+)\" and \"([\\w\\s&]+)\"$")
    public void loginToApplication(String userName,String password,String scenarioName){
        LoginPage loginPage = new LoginPage ( getDriver());
        String appUserName= CucumberHooks.envConfig.readTestDataByKey(userName);
        String appUserPassword= CucumberHooks.envConfig.readTestDataByKey(password);
        loginPage.validateLoginPageTitle(appUserName,appUserPassword);
    }

    @Given( "^user login to the application using \"([\\w\\s&]+)\" and \"([\\w\\s&]+)\"$")
    public void userLogsIntoApplication(String userName,String password){
        LoginPage loginPage=(LoginPage)RunContext.getScenarioContext
                (DriverFactory.getInstance().getDriver()).getPageObject();
        String appUserName= CucumberHooks.envConfig.readTestDataByKey(userName);
        String appUserPassword= CucumberHooks.envConfig.readTestDataByKey(password);
        loginPage.validateLoginPageTitle(appUserName,appUserPassword);
    }

    @When("^verify user is on HomePage \"([\\w\\s&]+)\"$" )
    public void verifyUserIsOnHomePage(String scenarioName){
        System.out.println(scenarioName + " When Driver Instance "+getDriver());
        HomePage homePage= new HomePage( getDriver());
        Assert.assertTrue(homePage.verifyUserIsOnHomePage().toLowerCase().contains( "home"));
    }
    @Then( "^user signouts from portal \"([\\w\\s&]+)\"$")
    public void userSignoutFromPortal(String scenarioName){
        System.out.println(scenarioName + "Then Driver Instance "+getDriver());
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.signOutFromPortal();
    }
    @Then( "^user signouts \"([\\w\\s&]+)\"$")
    public void userSignout(String scenarioName){
        System.out.println(scenarioName+ " user signouts Then Driver Instance "+getDriver());
        try{
        Thread.sleep( 2000 );
        }catch (Exception e){
        }
        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.signOutFromPortal();
    }
}
