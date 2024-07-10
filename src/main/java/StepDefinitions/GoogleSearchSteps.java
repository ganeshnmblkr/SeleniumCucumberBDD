package StepDefinitions;

import io.cucumber.java.en.*;
import pages.loginPage;

public class GoogleSearchSteps extends BaseSteps {
    @Given("user opens browser")
    public void user_opens_browser() {
        loginPage loginPage= new loginPage(getDriver());
        System.out.println(loginPage.validateLoginPageTitle());
//        System.out.println("Ganesh");
//        WebDriver driver = new ChromeDriver();
//        driver.get( "https://www.google.com/" );
    }

    @When("user type search")
    public void user_type_search() {
        System.out.println("Ganesh1");
    }

    @Then("user should get the result")
    public void user_should_get_the_result() {
        System.out.println("Ganesh1");
    }
}
