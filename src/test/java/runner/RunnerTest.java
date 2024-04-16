package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-report/Cucumber.json", "html:target/cucumber"},
        features = "src/test/resources/features/code_dao_cucumber.feature",
        glue = {"src.test.java.hooks", "src.test.java.stepdefinitions"}
)
public class RunnerTest {

}
