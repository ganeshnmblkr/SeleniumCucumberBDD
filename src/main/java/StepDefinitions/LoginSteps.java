package StepDefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSteps {
    @Given("user wants to test first step")
    public void user_wants_to_test_first_step() {
        System.out.println("user is inside given stepdffdff");
        System.out.println("Ajay");
//        WebDriver driver= new ChromeDriver();
//        driver.get( "https://au.yahoo.com/" );
    }
    @When("^user runs file \"([\\w\\s&]+)\"$")
    public void user_runs_file(String scenarioName ) {
        System.out.println(scenarioName+ " user runs file Driver Instance "+getDriver());
    }
    @Then("scenario should run successfully")
    public void scenario_should_run_successfully() {
        System.out.println("user is inside then step");
    }
    @Given( "LoginPage Given" )
    public void loginPageGiven(){
        System.out.println(" LoginPage Given Driver Instance "+getDriver());
    }
    @When( "Login Page When" )
    public void loginPageWhen(){
        System.out.println(" LoginPage When Driver Instance "+getDriver());
    }
    @Then( "login Page Then" )
    public void loginPageThen(){
        System.out.println(" LoginPage Then Driver Instance "+getDriver());
    }
}
