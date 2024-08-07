import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
        glue={ "StepDefinitions" , "cucumberHooks" },
        monochrome = true,
//        tags = "@smoke",
plugin ={"pretty","html:target/Reports/HtmlReports.html",
"json:target/Reports/JSONreports.json","junit:target/Reports/XMLreports.xml"})
public class RunTest  extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
        public Object[][] scenarios(){
        return super.scenarios();
        }
}
