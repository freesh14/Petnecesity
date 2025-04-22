import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class InlogStepdefs {
    WebDriver driver;


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("");
    }

    @When("I enter test@example.com")
    public void iEnterTestExampleCom() {
    }

    @And("I enter {string}")
    public void iEnter(String arg0) {
    }

    @And("I click on login")
    public void iClickOnLogin() {
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String arg0) {
    }
}
