package cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private WebDriverManager webDriverManager;

    public TestContext(){
        webDriverManager = WebDriverManager.chromedriver();
    }

    public WebDriver getWebDriver() {
        webDriverManager.setup();
        return webDriverManager.getWebDriver();
    }

}