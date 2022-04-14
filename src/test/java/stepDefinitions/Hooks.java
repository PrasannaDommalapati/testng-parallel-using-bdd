package stepDefinitions;


import com.google.common.io.Files;
//import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {
//    TestContext testContext;
//    public Hooks(TestContext context) {
//        testContext = context;
//    }

    @Before
    public void beforeScenario(Scenario scenario) {
//        Reporter.assignAuthor("ToolsQA - Lakshay Sharma");
//        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//        Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
//        Reporter.setSystemInfo("Selenium", "3.7.0");
//        Reporter.setSystemInfo("Maven", "3.5.2");
//        Reporter.setSystemInfo("Java Version", "1.8.0_151");
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
//        if (scenario.isFailed()) {
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            try {
//                //This takes a screenshot from the driver at save it to the specified location
//               // File sourcePath = ((TakesScreenshot) testContext.getWebDriver()).getScreenshotAs(OutputType.FILE);
//
//                //Building up the destination path for the screenshot to save
//                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
//                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
//
//                //Copy taken screenshot from source location to destination location
//                //Files.copy(sourcePath, destinationPath);
//
//                //This attach the specified screenshot to the test
//                //Reporter.addScreenCaptureFromPath(destinationPath.toString());
//            } catch (IOException e) {
//            }
//        }
    }


    @After(order = 0)
    public void AfterSteps() {
//        testContext.getWebDriver().quit();
    }
}
