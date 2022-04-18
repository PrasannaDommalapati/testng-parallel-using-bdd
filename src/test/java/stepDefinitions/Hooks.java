package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Hooks {
    WebDriver driver;

    public Hooks(LocalWebDriverManager localWebDriverManager) {
        driver = localWebDriverManager.getDriver();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
//        Reporter.assignAuthor("ARAIN - Prasanna Dommalapati");
//        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//        Reporter.setSystemInfo("Machine", System.getProperty("os.name"));
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            String screenshotName = scenario
                    .getName()
                    .replaceAll(" ", "_");
            scenario.attach(screenshot, "image/png", screenshotName);
        }
    }
}
