import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @When("I register with name {string} {string}, email {string}, and passwords {string} {string}")
    public void iRegisterWithNameEmailAndPasswords(String firstname, String lastname, String email, String password, String confirmPassword) {

        driver.findElement(By.cssSelector("input[type='datetime']"))
                .sendKeys("05-04-2005");
        driver.findElement(By.cssSelector("[name='Forename']")).sendKeys(firstname);
        driver.findElement(By.cssSelector("[name='Forename']")).sendKeys(lastname);
        driver.findElement(By.cssSelector("[name='EmailAddress']")).sendKeys(email);
        driver.findElement(By.cssSelector("[name='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[name='ConfirmPassword']")).sendKeys(confirmPassword);



    }

    @And("I <acceptTerms>")
    public void iAcceptTerms(String acceptTerms) {
        WebDriverWait checkbox = driver.findElement(By.cssSelector(""));
        if (!acceptTerms.equalsIgnoreCase("accept")){
            if (!checkbox.isSelected()){
                checkbox.click();
            }else {
                if (checkbox.isSelected()){
                    checkbox.click();
                }
            }
            driver.findElement(By.cssSelector(""))
        }
    }

    @Then("<expectedResult>")
    public void expectedresult() {
    }
}
