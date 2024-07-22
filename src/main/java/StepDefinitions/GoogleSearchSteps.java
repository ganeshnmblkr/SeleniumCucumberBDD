package StepDefinitions;

import cucumberHooks.CucumberHooks;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomePage;
import pages.loginPage;

public class GoogleSearchSteps extends BaseSteps {
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
        System.out.println(scenarioName+" Given Driver Instance "+getDriver());
        loginPage loginPage= new loginPage(getDriver());
        String appUserName= CucumberHooks.envConfig.readTestDataByKey( userName);
        String appUserPassword= CucumberHooks.envConfig.readTestDataByKey( password);
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
        loginPage loginPage= new loginPage(getDriver());
        loginPage.signOutFromPortal();
    }
    @Then( "^user signouts \"([\\w\\s&]+)\"$")
    public void userSignout(String scenarioName){
        System.out.println(scenarioName+ " user signouts Then Driver Instance "+getDriver());
        try{
        Thread.sleep( 2000 );
        }catch (Exception e){
        }
        loginPage loginPage= new loginPage(getDriver());
        loginPage.signOutFromPortal();
    }
}
