package cucumberHooks;

import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScenarioContext {
    private TestScenario testScenario;
    private String mainWindowsHandle;
    private Scenario scenario;
    private Object pageObject;
}
