package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class GoogleSteps {
    WebDriver driver;

    public GoogleSteps(LocalWebDriverManager manager){
        this.driver = manager.getDriver();
        driver.navigate().to("https://google.co.uk");
        System.out.println("i am here"+ (driver == null));

    }
    @Given("I am in {string}")
    public void i_am_in(String string) {
        System.out.println(string);
    }
    @When("I enter a keyword {string}")
    public void i_enter_a_keyword(String string) {
        System.out.println(string);

    }
    @Then("I should see the page title contains {string}")
    public void i_should_see_the_page_title_contains(String string) {
        System.out.println(string);
    }
}
