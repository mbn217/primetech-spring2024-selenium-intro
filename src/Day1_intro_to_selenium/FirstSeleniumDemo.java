package Day1_intro_to_selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumDemo {


    public static void main(String[] args){
        //Set the path to the chromeDriver executable file
        System.setProperty("webdriver.chrome.driver","browsers/chromedriver");

        //Create a  ChromeDriver instance
        WebDriver chromeDriver = new ChromeDriver();
        //Open a Website
        chromeDriver.get("https://www.google.com");


    }


}
