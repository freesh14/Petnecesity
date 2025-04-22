import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyUserStepdefs {
    private WebDriver driver;
    private WebDriverWait wait;
    private String actualEmail;

    private void waitAndClick(String css){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
    }
    private void waitToBeDisplayed(String css) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }
    @Given("I am on the registration page using {string}")
    public void iAmOnTheRegistrationPageUsing(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver= new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().maximize();
    }

    @When("I register with name {string} {string}, email {string} {string}, and passwords {string} {string}")
    public void iRegisterWithNameEmailAndPasswords(String firstname, String lastname, String email, String confirmemail, String password, String confirmPassword) {
        driver.findElement(By.cssSelector("input[name='DateOfBirth']"))
                .sendKeys("05-04-2005");
        driver.findElement(By.cssSelector("[name='Forename']")).sendKeys(firstname);
        driver.findElement(By.cssSelector("[name='Surname']")).sendKeys(lastname);
        driver.findElement(By.cssSelector("[name='EmailAddress']")).sendKeys(email);
        driver.findElement(By.cssSelector("[name='ConfirmEmailAddress']")).sendKeys(confirmemail);
        driver.findElement(By.cssSelector("[name='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[name='ConfirmPassword']")).sendKeys(confirmPassword);
    }



    @And("I {string}")
    public void iAcceptTerms(String acceptTerms) {
        if (acceptTerms.equalsIgnoreCase("accept")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='sign_up_26'] span.box"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='sign_up_25'] span.box"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span.box"))).click();


            WebElement joinButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("join")));

            if (joinButton.isEnabled()) {
                joinButton.click();
            } else {
                System.out.println("Join button is not enabled!");
            }
        }


    }

    @Then("{string}")
    public void expectedresult(String result) {
        String pageSource = driver.getPageSource();


        if ( result.equalsIgnoreCase("THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND")) {

            WebElement thankYouMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("h2.bold.gray.text-center.margin-bottom-40")));
            assertTrue(thankYouMessage.isDisplayed());
        } else {

            assertTrue(pageSource.contains(result), "Expected error not found!");
        }

        System.out.println("Result: " + result);
        driver.quit();
    }

    }


