package Day2_Locators_functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByClassNameExample {

    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        //This line will maximize the browser
        firefoxDriver.manage().window().maximize();

        firefoxDriver.get("https://www.google.com");

        //get the title of the webpage
        System.out.println("Title of the page is : " + firefoxDriver.getTitle());

        //we used className to find the element
        WebElement googleSearchBox =  firefoxDriver.findElement(By.className("gLFyf"));
        //inserting a value into the search box
        googleSearchBox.sendKeys("Today news");

        //It will stop the thread for 5 seconds and then continue with the rest of the work
        Thread.sleep(5000); //wait for 5 seconds

        //quit() will close the browser
        firefoxDriver.quit();



    }
}
