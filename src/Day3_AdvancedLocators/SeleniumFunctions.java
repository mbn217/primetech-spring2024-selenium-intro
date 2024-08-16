package Day3_AdvancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFunctions {

    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement aboutLink = driver.findElement(By.linkText("About"));
        aboutLink.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println(driver.getTitle());//will get the title of the page
        System.out.println("----------------");
        System.out.println(driver.getCurrentUrl());//this wll get the url of the page we navigated to

        driver.close();//this will close the current browser you have open but it will not kill the session
            //driver will not be null

        driver.quit();//this will kill the browser and also change driver to null





    }
}
