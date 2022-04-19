package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "",
        features = "src/test/resources/features",
        glue= {"stepDefinitions"},
        plugin = {"pretty:com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter",
                "json:target/cucumber-report.json"},
        dryRun = false,
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}