package Day3_AdvancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1Solution {

    /**
     * Task 1: Open Browser and Navigate to Google
     * Objective: Write a script to automate the following:
     * Open a Chrome browser.
     * Maximize the browser
     * Navigate to https://www.bing.com.
     * Find the search input box by its id and enter the text “Selenium WebDriver”.
     * Instructions:
     * Use the By.id locator to find the search box.
     * Do not close the browser window immediately
     * after entering the text; let it stay open for manual verification (HINT: Use Thread.Sleep()).
     */

    public static void main(String[] args) throws InterruptedException {
        // create a chrome driver instance
        WebDriver chromeDriver = new ChromeDriver();

        /* This line will maximize the browser screen */
        chromeDriver.manage().window().maximize();

        //Navigate to bing.com
        chromeDriver.get("https://www.bing.com");

        //WebElement searchBox = chromeDriver.findElement(By.id("sb_form_q"));

        WebElement searchBox = chromeDriver.findElement(By.className("sb_form_ta"));


        // sendKeys is used to insert value into a text box in the webpage
        searchBox.sendKeys("Selenium WebDriver");

        // Close window after 5 seconds
        Thread.sleep(5000);

        chromeDriver.quit();
    }
}
