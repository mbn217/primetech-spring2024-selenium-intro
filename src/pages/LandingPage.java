package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LandingPage {

    //we need a constructor
    // what this line telling is:  hey pageFactory, initialize all the elements in this class with the driver instance
    // whenever an object of this class is created.
    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //-------------------- WebElements ------------------

    @FindBy(xpath = "(//div[.='Swag Labs'])[2]")
    public WebElement mainLabel;



}
