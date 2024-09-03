package Day9_SeleniumFunctionsPart5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class DriverQuitvsDriverClose {
    public static void main(String[] args) {
        driverCloseQuitExample();
    }
    public static void driverCloseQuitExample(){
        //What's the difference between driver.close and driver.quit

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.primetech-apps.com/practice/browser-windows");
        WebElement newTabButton = driver.findElement(By.xpath("//a[@id='newTab']"));
        newTabButton.click();

        ArrayList<String> allWindows = new ArrayList<>(driver.getWindowHandles());

        //driver.close(); //will this close 1st tab or second tab?
        driver.quit();
        /**
         * close() , if you have more than 1 tab then it will close only the tab where driver
         * is focusing
         *
         * if you have only one tab then it will close that tab
         */

        /**
         * driver.quit() will kill all the running instances of the driver (it will close
         * all the tabs that are open , regardless of the focus) and make the driver null
         */


        System.out.println(driver);



    }
}
