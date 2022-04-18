package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


public class LocalWebDriverManager {

    private WebDriver driver;
    private WebDriverManager webDriverManager;

    private void createWebDriver() {
        webDriverManager = WebDriverManager.edgedriver();
        webDriverManager.setup();
        driver = webDriverManager.create();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            webDriverManager = WebDriverManager.chromedriver();
            webDriverManager.setup();
        }
         driver = webDriverManager.create();


        return driver;
    }

}