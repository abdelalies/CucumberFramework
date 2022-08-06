package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    Alert alert;
    WebDriverWait letswait;
    Select letsSelect;
    Actions act;


//    This method returns true when given element is found hidden or displayed on the UI.

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }







//    Switches the driver focus to the alert if present.
    public void switchToAlert() {
        alert = Driver.getDriver().switchTo().alert();
    }

//    gets the text on the alert and returns it as a string
    public String alertGetText() {
        return alert.getText();
    }

    public void alertAccept() {
        alert.accept();
    }

    public void alertDismiss() {
        alert.dismiss();
    }

    public void sendKeysOnAlert(String name) {
        alert.sendKeys(name);
    }

//    This method waits for an alert to be present
    public void waitUntilAlertIsPresent() {
        letswait = new WebDriverWait(Driver.getDriver(), 10);
        letswait.until(ExpectedConditions.alertIsPresent());
    }

//    This method waits the given element to be visible on the page
    public void waitUntilElementVisible (WebElement element) {
        letswait = new WebDriverWait(Driver.getDriver(), 10);
        letswait.until(ExpectedConditions.visibilityOf(element));
    }

//    This method waits until the given element is clickable
    public void waitUntilElementClickable (WebElement button) {
        letswait = new WebDriverWait(Driver.getDriver(), 10);
        letswait.until(ExpectedConditions.elementToBeClickable(button));
    }

//    This is for drop down - it selects from a drop down by visible text
//    There is 3 types of select, by selectbyvisibletext, selectbyindex, and selectbyvalue
    public void selectByVisibleText (WebElement element, String optionToSelect) {
        letsSelect = new Select(element);
        letsSelect.selectByVisibleText(optionToSelect);
    }
//    This is from the above 3 types, selectByValue
    public void selectByValue (WebElement element, String valueTobeSelected) {
        letsSelect = new Select(element);
        letsSelect.selectByValue(valueTobeSelected);
    }
// This is to hover over an element
    public void hoverOverToElement(WebElement element) {
        act = new Actions(Driver.getDriver());
        act.moveToElement(element).perform();
    }

//    This is to drag the source element to the target element
    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        act = new Actions(Driver.getDriver());
        act.dragAndDrop(sourceElement, targetElement).build().perform();
    }

//    This method is for deleting the pre-populated vale of a field.
    public void clearValueOfaField(WebElement element) {
        String temp = element.getAttribute("value");
        for (int i = 0; i < temp.length(); i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

//        Or this one also deletes the pre-populated value
        public void clearTextOfTheField(WebElement element) {
            element.sendKeys(Keys.chord(Keys.CONTROL), "a");
            element.sendKeys(Keys.DELETE);
        }







}
