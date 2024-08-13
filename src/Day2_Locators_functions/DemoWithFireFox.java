package Day2_Locators_functions;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class DemoWithFireFox {


    public static void main(String[] args) {
        /**
         * Go to google.com
         * Insert Selenium Automation into the input box
         */
        //Interface     referenceType(object)   =    new object    from firefox class
        WebDriver       firefoxDriver           =    new            FirefoxDriver();
        firefoxDriver.get("https://www.google.com");
        //You can also use below code to instantiate a firefox object
        //FirefoxDriver ff = new FirefoxDriver();

        WebElement searchBox = firefoxDriver.findElement(By.id("APjFqb"));
        //senKeys is used to insert value into a textbox in the webpage
        searchBox.sendKeys("Selenium Automation");









    }


}
