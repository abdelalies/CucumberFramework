package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SauceDemoLogin {

    public SauceDemoLogin() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "user-name")
    public WebElement userNameFld;

    @FindBy (id = "password")
    public WebElement passwordFld;

    @FindBy (id = "login-button")
    public WebElement loginBtn;

    @FindBy (css = ".title")
    public WebElement InventoryPageText;

    @FindBy (css = ".inventory_item")
    public List <WebElement> inventoryItems;

    @FindBy (css = ".bot_column")
    public WebElement bot;

    @FindBy (xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;










}
