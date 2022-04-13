package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/main/resources/features", glue = "stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {
}