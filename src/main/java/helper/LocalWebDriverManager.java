package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.disposables.Disposable;
import org.openqa.selenium.WebDriver;


public class LocalWebDriverManager implements Disposable {

    private WebDriver driver;
    private WebDriverManager webDriverManager;

    private void createWebDriver() {
        webDriverManager = WebDriverManager.edgedriver();
        webDriverManager.setup();
        driver = webDriverManager.getWebDriver();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            webDriverManager = WebDriverManager.chromedriver();
            webDriverManager.setup();
        }
        return driver = webDriverManager.getWebDriver();
    }

    @Override
    public void dispose() {
        driver.quit();
    }

    @Override
    public boolean isDisposed() {
        return false;
    }

}