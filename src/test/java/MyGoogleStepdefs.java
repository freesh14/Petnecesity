import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyGoogleStepdefs {

    WebDriver driver;
    WebDriverWait wait;


    @Given("The user is on the Google homepage")
    public void theUserIsOnTheGoogleHomepage() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/webhp?hl=sv&sa=X&ved=0ahUKEwjaw-jogNaMAxXrBxAIHb9mD5IQPAgI");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[1]/div")).click();
    }

    @When("The user searches for {string}")
    public void theUserSearchesFor(String OpenAI) {


        driver.findElement(By.cssSelector("[name='q']")).sendKeys("OpenAI" + Keys.ENTER);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='reCAPTCHA']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#recaptcha-anchor")));
        driver.findElement(By.cssSelector("span#recaptcha-anchor")).click();







    }

    @Then("The search results should be displayed")
    public void theSearchResultsShouldBeDisplayed() {
        boolean resultsDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#APjFqb"))).isDisplayed();
        if (!resultsDisplayed) {
            throw new AssertionError("Search results were not displayed.");
        }
        driver.quit(); // Optional: Clean up after test
    }
}
