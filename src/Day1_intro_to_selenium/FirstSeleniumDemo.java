package Day1_intro_to_selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumDemo {


    public static void main(String[] args){
        //Set the path to the chromeDriver executable file
        //In version Selenium 3.x.x
        //System.setProperty("webdriver.chrome.driver","browsers/chromedriver");
        /*
        WebDriverManager--> Manage the drivers on runtime--> It will go to the internet and grab the
        right browser driver for your system
         */
        //Create a  ChromeDriver instance
        WebDriver chromeDriver = new ChromeDriver();
        //Open a Website
        chromeDriver.get("https://www.cnn.com");






    }


}
