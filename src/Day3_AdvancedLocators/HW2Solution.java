package Day3_AdvancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2Solution {

    /**
     * Task 2: Open Browser and Navigate to Wikipedia
     * Objective: Write a script to perform the following actions:
     * Open a Chrome browser.
     * Maximize the browser
     * Navigate to https://www.wikipedia.org.
     * Locate the search input box by its id and type “Selenium (software)” into the box.
     */

    public static void main(String[] args) throws InterruptedException {
        // create a chrome driver instance
        WebDriver chromeDriver = new ChromeDriver();

        /* This line will maximize the browser screen */
        chromeDriver.manage().window().maximize();

        //Navigate to bing.com
        chromeDriver.get("https://www.wikipedia.org");
        //Search box using id
        try {
            WebElement wikiSearchBox = chromeDriver.findElement(By.id("searchInpu"));
            wikiSearchBox.sendKeys("Selenium (software)");
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("something happen");
        }finally { // this will always get executed
            chromeDriver.quit();
        }
        //anything here will get executed




    }



}
