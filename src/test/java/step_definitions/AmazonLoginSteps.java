package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AmazonLoginPage;
import utilities.Driver;
import utilities.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class AmazonLoginSteps {

    AmazonLoginPage amazonlp = new AmazonLoginPage();

    @Given("I am on amazon home page")
    public void i_am_on_amazon_home_page() {
        Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));

    }

    @Given("the sign in button displays")
    public void the_sign_in_button_displays() {
        Assert.assertTrue(amazonlp.signInBtn.isDisplayed());


    }

    @When("I click on the Sign in button")
    public void i_click_on_the_sign_in_button() {
        amazonlp.signInBtn.click();


    }

    @Then("I should be directed to log in page")
    public void i_should_be_directed_to_log_in_page() {
        Assert.assertTrue(amazonlp.emailBox.isDisplayed());


    }

//    invalid user test #Starts

    @Given("I'm on the login page")
    public void i_m_on_the_login_page() {
        Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
        amazonlp.signInBtn.click();
        Assert.assertTrue(amazonlp.emailBox.isDisplayed());
    }

    @When("I enter an invalid email address {string}")
    public void i_enter_an_invalid_email_address(String email) {
        amazonlp.emailBox.sendKeys(email);
    }

    @When("I click continue button")
    public void i_click_continue_button() {
        amazonlp.continueBtn.click();

    }

    @Then("An error message should be displayed {string}")
    public void an_error_message_should_be_displayed(String expectedErrorMessage) {
        Assert.assertTrue(amazonlp.errorMessage.isDisplayed());
        String actualText = amazonlp.errorMessage.getText().trim();
        Assert.assertEquals(actualText, expectedErrorMessage);
    }

    @Then("I should still be in the login page")
    public void i_should_still_be_in_the_login_page() {
        Assert.assertTrue(amazonlp.signInBtn.isDisplayed());
    }


//    invalid user test #ends
}
