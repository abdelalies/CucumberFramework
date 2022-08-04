package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AmazonSearch;
import utilities.Driver;
import utilities.PropertiesReader;

public class AmazonSearchSteps {

    AmazonSearch amazonSO = new AmazonSearch();
// Amazon search #starts

    @When("I search item {string}")
    public void i_search_item(String items) {
        amazonSO.searchFld.sendKeys(items);
    }

    @When("I click the search button")
    public void i_click_the_search_button() {
        amazonSO.searchBtn.click();
    }

    @Then("search item {string} should be displayed in the search bar")
    public void search_item_should_be_displayed_in_the_search_bar(String items) {
       String actualTxt = amazonSO.resultsForTxt.getText();
       String trimmedText = actualTxt.substring(1, actualTxt.length()-1);
        Assert.assertEquals(trimmedText, items);

    }

//    Amazon search #ends

}
