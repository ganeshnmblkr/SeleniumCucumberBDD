package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("user wants to test first step")
    public void user_wants_to_test_first_step() {
        System.out.println("user is inside given stepdffdff");
        System.out.println("Ajay");
//        WebDriver driver= new ChromeDriver();
//        driver.get( "https://au.yahoo.com/" );
    }
    @When("user runs file")
    public void user_runs_file() {
        System.out.println("user is inside when step");
    }
    @Then("scenario should run successfully")
    public void scenario_should_run_successfully() {
        System.out.println("user is inside then step");
    }
}
