package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "",
        features = "src/test/resources/features",
        glue= {"stepDefinitions"},
        plugin = { "pretty","html:target/cucumber-reports/report.html",
                "com.cucumber.listener.ExtentCucumberFormatter"},
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}