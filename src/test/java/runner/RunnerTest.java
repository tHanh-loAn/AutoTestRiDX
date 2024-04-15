package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-report/Cucumber.json", "html:target/cucumber"},
        features = "src/test/resources/features/",
        glue = {"hooks", "stepdefinitions"}
)
public class RunnerTest {

    /*

     */
}
