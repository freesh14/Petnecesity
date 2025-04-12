import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetnecessityStepdefs {

    private WebDriver driver;
    private String uniquecode = String.valueOf(UUID.randomUUID());
    //String email = System.currentTimeMillis()+"testgubbe@mailnesia.com";
    private String email = uniquecode+"@mailnesia.com";

    private void waitAndClick(String css){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).click();
    }
    @Given("I am at petnecessity page")
    public void iAmAtPetnecessityPage(String browser) {
        if (browser.equals("chrome")) driver = new ChromeDriver();
        if (browser.equals("firefox")) driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://www.petnecessity.co.uk/?srsltid=AfmBOoqB3nW_I6TxVhuYJGe9JMMX_z97cbMnRoIG2plMFaHqYPRerfnS");
        driver.findElement(By.cssSelector("button.accept")).click();
        waitAndClick(".sqs-popup-overlay-close");
        driver.manage().window().maximize();
    }

    @When("I create an account")
    public void iCreateAnAccount() {
        driver.findElement(By.cssSelector(".user-accounts-link")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("accountFrame")));
        driver.findElement(By.cssSelector("[href=\"/account/login/create\"]")).click();
        driver.findElement(By.cssSelector("[data-test=\"create-account-first-name\"]"))
                .sendKeys("Test");
        driver.findElement(By.cssSelector("[data-test=\"create-account-last-name\"]"))
                .sendKeys("Testsson");
        driver.findElement(By.cssSelector("[data-test=\"create-account-email\"]"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("[data-test=\"create-account-password\"]"))
                .sendKeys("abc123");
        driver.findElement(By.cssSelector("[data-test=\"create-account-confirm-password\"]"))
                .sendKeys("abc123");
    }

    @Then("The account is successfully created")
    public void theAccountIsSuccessfullyCreated() {
        driver.findElement(By.cssSelector("[href?=\"/account/profile\"]")).isDisplayed();
        driver.findElement(By.cssSelector("[href?=\"/account/profile\"] > div")).isDisplayed();
        driver.findElement(By.cssSelector("[href?=\"/account/profile\"] > div > div")).isDisplayed();
        System.out.println(driver.findElement(By
                        .cssSelector("[href?=\"/account/profile\"] > div > div")).getText());



        String text = driver.findElement(By
                .cssSelector("[href=\"/account/profile\" > div > div:nth-child(2)]")).getText();
        System.out.println(text);
        assertEquals(email, text);
    }
}
