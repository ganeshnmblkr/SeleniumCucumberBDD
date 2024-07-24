package cucumberHooks;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "cucumberHooks.TestScenario")
@Getter
@Setter
public class TestScenario {
    private String scenario;
    private String testCaseID;

}
