package helper;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver webDriver;

    public BasePage(WebDriver driver) {
        webDriver = driver;
    }

    public void enterTextTo(By identifier, String textToEnter) {
        try {
            webDriver.findElement(identifier).sendKeys(textToEnter);
        } catch (NoSuchElementException e) {
            System.out.println("Element is:::" + identifier);
            System.out.println("Exception is:::" + e);
        }
    }

    public void enterKeys(By locator, Keys keys) {
        try {
            webDriver.findElement(locator).sendKeys(keys);
        } catch (NoSuchElementException e) {
            System.out.println("Element is:::" + locator);
            System.out.println("Exception is:::" + e);
        }
    }

    public void clearTextIn(By identifier) {
        try {
            webDriver.findElement(identifier).clear();
        } catch (Exception e) {
            System.out.println("Element is:::" + identifier);
            System.out.println("Exception is:::" + e);
        }
    }

    public void clickOn(By identifier) {
        try {
            webDriver.findElement(identifier).click();
        } catch (Exception e) {
            System.out.println("Element is:::" + identifier);
            System.out.println("Exception is:::" + e);
        }
    }

    public void selectDropDown(By identifier, String value) {
        try {
            Select dropDown = new Select(webDriver.findElement(identifier));
            dropDown.selectByIndex(0);
            enterTextTo(identifier, value);
        } catch (NoSuchElementException e) {
            System.out.println("Element is:::" + identifier);
            System.out.println("Exception is:::" + e);
        }
    }

    public void selectDropDownByIndex(By identifier, int indexValue) {
        try {
            Select dropDown = new Select(webDriver.findElement(identifier));
            dropDown.selectByIndex(indexValue);
        } catch (Exception e) {
            System.out.println("Element is:::" + identifier);
            System.out.println("Exception is:::" + e);
        }
    }

    public String getText(String locatorType, String value) {
        try {
            return elementFinder(locatorType, value).getText();
        } catch (NoSuchElementException e) {
            System.out.println("Exception is::" + e);
            return null;
        }
    }

    public void waitUntil(By identifier) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(identifier));

    }

    public boolean isElementEnabled(By identifier) {
        try {
            return webDriver.findElement(identifier).isEnabled();
        } catch (NoSuchElementException e) {
            System.out.println(e);
            return false;
        }
    }
    //################################# Utility Methods ###################################

    public WebElement elementFinder(By locator) {
        try {
            return webDriver.findElement(locator);
        } catch (NoSuchElementException e) {
            System.out.println(e);
            return null;
        }
    }

    public void alertHandler() {
        try {
            webDriver.switchTo().alert().accept();
        } catch (NoSuchElementException e) {
            System.out.println("Alert not present");
        }
    }

    public WebElement elementFinder(String locatorTpye, String value) {

        if (locatorTpye.equals("id"))
            return webDriver.findElement(By.id(value));
        else if (locatorTpye.equals("name"))
            return webDriver.findElement(By.name(value));
        else if (locatorTpye.equals("xpath"))
            return webDriver.findElement(By.xpath(value));
        else if (locatorTpye.equals("css"))
            return webDriver.findElement(By.cssSelector(value));
        else if (locatorTpye.equals("tagName"))
            return webDriver.findElement(By.tagName(value));
        else if (locatorTpye.equals("linkText"))
            return webDriver.findElement(By.linkText(value));
        else if (locatorTpye.equals("partialLinkText"))
            return webDriver.findElement(By.partialLinkText(value));
        else {
            System.out.println("No such element type available");
            return null;
        }

    }

    public List<WebElement> listOfElements(By locator) {
        List<WebElement> elementsList = webDriver.findElements(locator);

        return elementsList;
    }

    public void waitForSomeTime() {
        try {
            webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SleepForSomeTime() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void explicitWait(String xpath) {
        WebDriverWait fluentWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        fluentWait.ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public String pastDate(int days) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        Date myDate = new Date(System.currentTimeMillis());
        // System.out.println("result is "+ dateFormat.format(myDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DATE, -days);
        //System.out.println(dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    public String futureDate(int days) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        Date myDate = new Date(System.currentTimeMillis());
        // System.out.println("result is "+ dateFormat.format(myDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DATE, +days);
        //System.out.println(dateFormat.format(cal.getTime()));
        return dateFormat.format(cal.getTime());
    }

    public String pageTitle() {
        try {
            return webDriver.getTitle();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public void switchWindow() {
        String parentWindow = webDriver.getWindowHandle();
        Set<String> handles = webDriver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                webDriver.switchTo().window(windowHandle);//<!--Perform your operation here for new window/ to child window-->
                //bcl.switchTo().window(parentWindow); //Control to parent window
                webDriver.manage().window().maximize();
            }
        }

    } // End of switching window method.

    public void uploadDocument(String file) throws AWTException {
        StringSelection ss = new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void downloadDocHandler() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public void dropDownHandle(By locator, String value) {
        Select dropDown = new Select(elementFinder(locator));
        dropDown.selectByIndex(0);
        elementFinder(locator).sendKeys(value);
    }
}