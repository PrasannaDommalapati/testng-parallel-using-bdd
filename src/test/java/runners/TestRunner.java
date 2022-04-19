package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "",
        features = "src/test/resources/features",
        glue= {"stepDefinitions"},
        dryRun = false,
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}