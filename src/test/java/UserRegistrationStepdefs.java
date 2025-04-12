import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRegistrationStepdefs {
    WebDriver driver;
    String uniquecode = String.valueOf(UUID.randomUUID());
    String email = uniquecode + "@mailnesia.com";

    private void waitAndClick(String css) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).click();

    }
    @Given("the test starts with this")
    public void theTestStartsWithThis() {
        System.out.println("The test starts with this");

    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {

        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().maximize();
    }

    @When("I fill in the correct user data")
    public void iFillInTheCorrectUserData() {

        driver.findElement(By.cssSelector("input[type='datetime']"))
                .sendKeys("05-04-2005");
        driver.findElement(By.cssSelector("[name='Forename']"))
                .sendKeys("Joe");
        driver.findElement(By.cssSelector("[name='Surname']"))
                .sendKeys("Fox");
        driver.findElement(By.cssSelector("[name='EmailAddress']"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("[name='ConfirmEmailAddress']"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("[name='Password']"))
                .sendKeys("password123");
        driver.findElement(By.cssSelector("[name='ConfirmPassword']"))
                .sendKeys("password123");

        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']"))
                .click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']"))
                .click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']"))
                .click();
        //driver.findElement(By.cssSelector("[name='join']"))
                //.click();





    }

    @Then("the user should be created and I get a confirmation message")
    public void theUserShouldBeCreatedAndIGetAConfirmationMessage() {

        waitAndClick("[name='join']");
        WebElement confirmationMessage = driver.findElement(By.cssSelector("h2.bold.gray.text-center.margin-bottom-40"));
        assertTrue(confirmationMessage.isDisplayed());
        System.out.println("User created successfully: " + confirmationMessage.getText());
        //driver.quit();
    }

    @When("I fill in the correct user data without a last name")
    public void iFillInTheCorrectUserDataWithoutALastName() {

        driver.findElement(By.cssSelector("input[type='datetime']"))
                .sendKeys("05-04-2005");
        driver.findElement(By.cssSelector("[name='Forename']"))
                .sendKeys("Joe");
        driver.findElement(By.cssSelector("[name='EmailAddress']"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("[name='ConfirmEmailAddress']"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("[name='Password']"))
                .sendKeys("password123");
        driver.findElement(By.cssSelector("[name='ConfirmPassword']"))
                .sendKeys("password123");

        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']"))
                .click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']"))
                .click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']"))
                .click();
    }

    @Then("I should see an error message about the missing last name")
    public void iShouldSeeAnErrorMessageAboutTheMissingLastName() {
        waitAndClick("[name='join']");
        WebElement errorMessage = driver.findElement(By.cssSelector("span[for='member_lastname']"));
        assertTrue(errorMessage.getText().contains("Last Name is required"));
        System.out.println("Error: " + errorMessage.getText());
        driver.quit();
    }

    @When("I fill in invalid passwords \\(the two passwords do not match)")
    public void iFillInInvalidPasswordsTheTwoPasswordsDoNotMatch() {
        driver.findElement(By.cssSelector("input[type='datetime']"))
                .sendKeys("05-04-2005");
        driver.findElement(By.cssSelector("[name='Forename']"))
                .sendKeys("Joe");
        driver.findElement(By.cssSelector("[name='Surname']"))
                .sendKeys("Fox");
        driver.findElement(By.cssSelector("[name='EmailAddress']"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("[name='ConfirmEmailAddress']"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("[name='Password']"))
                .sendKeys("password123");
        driver.findElement(By.cssSelector("[name='ConfirmPassword']"))
                .sendKeys("password1223");


    }

    @And("I accept the terms and conditions")
    public void iAcceptTheTermsAndConditions() {
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']"))
                .click();
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']"))
                .click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']"))
                .click();
    }

    @And("I click on {string}")
    public void iClickOn(String arg0) {
        waitAndClick("[name='join']");
    }

    @Then("I should see an error message stating that the passwords do not match")
    public void iShouldSeeAnErrorMessageStatingThatThePasswordsDoNotMatch() {
        WebElement errorMessage = driver.findElement(By.cssSelector("span[for=\"signupunlicenced_confirmpassword\"]"));
        assertTrue(errorMessage.getText().contains("Password did not match"));
        System.out.println("Error: " + errorMessage.getText());
        driver.quit();
    }

    @When("I fill in the correct user data again")
    public void iFillInTheCorrectUserDataAgain() {
        driver.findElement(By.cssSelector("input[type='datetime']"))
                .sendKeys("05-04-2005");
        driver.findElement(By.cssSelector("[name='Forename']"))
                .sendKeys("Joe");
        driver.findElement(By.cssSelector("[name='Surname']"))
                .sendKeys("Fox");
        driver.findElement(By.cssSelector("[name='EmailAddress']"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("[name='ConfirmEmailAddress']"))
                .sendKeys(email);
        driver.findElement(By.cssSelector("[name='Password']"))
                .sendKeys("password123");
        driver.findElement(By.cssSelector("[name='ConfirmPassword']"))
                .sendKeys("password123");
    }

    @And("I do not accept the terms and conditions")
    public void iDoNotAcceptTheTermsAndConditions() {

        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']"))
                .click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']"))
                .click();

        waitAndClick("[name='join']");
    }

    @Then("I should see an error message stating that the terms and conditions must be accepted")
    public void iShouldSeeAnErrorMessageStatingThatTheTermsAndConditionsMustBeAccepted() {
        WebElement errorMessage = driver.findElement(By.cssSelector("span[for='TermsAccept']"));
        assertTrue(errorMessage.getText().contains("You must confirm that you have read and accepted our Terms"));
        System.out.println("Error: " + errorMessage.getText());
        driver.quit();


    }
}
