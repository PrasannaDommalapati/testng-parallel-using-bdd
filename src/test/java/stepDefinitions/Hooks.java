package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class Hooks {
    WebDriver driver;
    static ExtentReports extent = new ExtentReports();
    static ExtentTest extentTest;
    static ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");


    public Hooks(LocalWebDriverManager localWebDriverManager) {
        driver = localWebDriverManager.getDriver();
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
        reporter.config().setReportName("Testng Parallel Bdd sample Report");
        reporter.config().setTheme(Theme.DARK);

        extent.attachReporter(reporter);
        extent.setSystemInfo("Blog Name", "ARAIN Academy");
        extent.setSystemInfo("Author", "Prasanna Dommalapati");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        extent.setSystemInfo("Machine", System.getProperty("os.name"));
    }
    @BeforeStep
    public void beforeStep(Scenario scenario) throws Exception {
        String featureName = FilenameUtils.getBaseName(scenario.getUri().toString());
        System.out.println(featureName);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        System.out.println("======>  This is after step  <======");
        if (!scenario.isFailed()) {

            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            String screenshotName = scenario
                    .getName()
                    .replaceAll(" ", "_");
            System.out.println("======>  This is after step not failed <======");

            scenario.attach(screenshot, "image/png", screenshotName);
        }
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        extentTest = extent.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (!scenario.isFailed()) {
            String screenshotPath= getScreenshot(driver);
            extentTest.fail("scenario.getThrowable().getMessage()", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @AfterAll
    public static void afterAll(){
        extent.flush();
    }

    private static String getScreenshot(WebDriver driver)
    {
        TakesScreenshot ts=(TakesScreenshot) driver;

        File src= ts.getScreenshotAs(OutputType.FILE);

        String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";

        File destination=new File(path);

        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }

        return path;
    }
}
