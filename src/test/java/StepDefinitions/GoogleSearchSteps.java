package StepDefinitions;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
    @Given("user opens browser")
    public void user_opens_browser() {
        System.out.println("Ganesh");
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
