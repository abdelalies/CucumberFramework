package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DemoQaDatePickerPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class DemoQADatePickerSteps {

    DemoQaDatePickerPage DemoQaP = new DemoQaDatePickerPage();
    BrowserUtils utils = new BrowserUtils();

    @Given("I'm on the date picker page {string}")
    public void i_m_on_the_date_picker_page(String url) {
        Driver.getDriver().get(url);
        Assert.assertTrue(DemoQaP.firstDatePicker.isDisplayed());

    }

    @When("I enter {string} to date picker")
    public void i_enter_to_date_picker(String date) {
        utils.clearValueOfaField(DemoQaP.firstDatePicker);
        DemoQaP.firstDatePicker.sendKeys(date);



    }

    @Then("Date entered should be selected")
    public void date_entered_should_be_selected() {
       String fDP = DemoQaP.firstDatePicker.getAttribute("value");
       Assert.assertEquals(fDP, "02/01/2006");


    }
}
