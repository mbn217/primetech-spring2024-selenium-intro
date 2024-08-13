package Day2_Locators_functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TaskOne {
    /**
     * Navigate to Yahoo.com
     * Inside the search box type : "Today News"
     */

    public static void main(String[] args) {
        //Step 1 : Navigate to Yahoo.com
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.yahoo.com");
        //Step 2 : Enter "Today News" into the search box
        WebElement yahooSearchBox = firefoxDriver.findElement(By.id("ybar-sbq"));
        yahooSearchBox.sendKeys("Today News");










    }



}
