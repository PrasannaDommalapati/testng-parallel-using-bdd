package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.LocalWebDriverManager;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait fluentWait;

    //Constructor
    public BasePage(LocalWebDriverManager manager) {
        this.driver = manager.getDriver();
        fluentWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Click Method
    public void click(By by) {
        waitVisibility(by).click();
    }
    //Write Text
    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }
    //Read Text
    public String readText(By by) {
        return waitVisibility(by).getText();
    }
    //Wait
    public WebElement waitVisibility(By by) {
        return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
