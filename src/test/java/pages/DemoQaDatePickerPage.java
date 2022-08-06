package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class DemoQaDatePickerPage {

    public DemoQaDatePickerPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "datePickerMonthYearInput")
    public WebElement firstDatePicker;

    @FindBy (css = ".react-datepicker__year-select")
    public WebElement yearDropDown;

    @FindBy (css = ".react-datepicker__month-select")
    public WebElement monthDropDown;

    @FindBy (css = ".react-datepicker__day")
    public List<WebElement> days;


    }




