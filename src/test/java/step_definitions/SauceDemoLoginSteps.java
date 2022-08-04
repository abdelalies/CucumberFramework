package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SauceDemoLogin;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;


public class SauceDemoLoginSteps {

    SauceDemoLogin SauceDemolp = new SauceDemoLogin();
    BrowserUtils utils = new BrowserUtils();

//    valid tests #starts
    @Given("I'm on the SauceDemo home page")
    public void i_m_on_the_sauce_demo_home_page() {
        Driver.getDriver().get(PropertiesReader.getProperty("sauceUrl"));

    }
    @When("I enter valid username {string} password {string}")
    public void i_enter_valid_username_password(String username, String password) {
        SauceDemolp.userNameFld.sendKeys(username);
        SauceDemolp.passwordFld.sendKeys(password);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        SauceDemolp.loginBtn.click();

    }
    @Then("I should be directed to user homepage")
    public void i_should_be_directed_to_user_homepage() {
        Assert.assertTrue(SauceDemolp.InventoryPageText.isDisplayed());
    }
    @Then("There should be {int} items in the page")
    public void there_should_be_items_in_the_page(Integer NumOfItems) {
        Assert.assertTrue(SauceDemolp.inventoryItems.size() == NumOfItems);
//        or you can use
//        Assert.assertSame(NumOfItems, SauseDemolp.inventoryItems.size());
    }
// valid test #ends

//    Invalid test #starts


    @When("I enter invalid username {string} invalid password {string}")
    public void i_enter_invalid_username_invalid_password(String username, String Ipassword) {
        SauceDemolp.userNameFld.sendKeys(username);
        SauceDemolp.passwordFld.sendKeys(Ipassword);
    }
    @Then("I shouldn't be logged in, still at the homepage")
    public void i_shouldn_t_be_logged_in_still_at_the_homepage() {
        Assert.assertTrue(SauceDemolp.bot.isDisplayed());
        Assert.assertFalse(utils.isElementPresent(SauceDemolp.bot));

    }
    @Then("I receive the following error message should display under password field {string}")
    public void i_receive_the_following_error_message_should_display_under_password_field(String errorMessage) throws InterruptedException {
        Assert.assertTrue(SauceDemolp.errorMessage.isDisplayed());
        String eActualText = SauceDemolp.errorMessage.getText().trim();
        Assert.assertEquals(errorMessage, eActualText);

        Thread.sleep(5000);

        Driver.quitDriver();

    }



}
