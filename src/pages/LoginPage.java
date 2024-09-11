package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {


    //Constructor to initialize the webdriver and elements on the page
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this); // selenium 4.19.0 you should use this
    }




    //Find the Elements that are part of the login page

    //Username element
    @FindBy(xpath="//input[@id='user-name']")//this line to find the element
    public WebElement username;//declaring the element object for the element

    //Password Element
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    //Login button element
    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[.='Epic sadface: Sorry, this user has been locked out.']")
    public WebElement errorMessageLabel;



}
