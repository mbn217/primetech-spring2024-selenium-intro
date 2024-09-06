package Day11_SeleniumUtilitiesAndFramework;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MoveToElement {
    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    public static void testCase1(){
        //go to sauce demo and hover over the main label called "Swag Labs"
        WebDriver driver = new ChromeDriver();
        driver.get("");
        WebElement element = driver.findElement(By.xpath("this is xpath for swag label"));
        moveToElement(driver, element);

        //double click on the element
        doubleClick(driver,element);
    }

    public static void testCase2(){
        //go to sauce demo and hover over the login button
        WebDriver driver = new ChromeDriver();
        driver.get("");
        WebElement element = driver.findElement(By.xpath("this is xpath for login button"));
        moveToElement(driver,element);

        //double click on this element
        doubleClick(driver, element);


        // Select a value from a dropdown
        WebElement selectElement = driver.findElement(By.xpath("//select[@name='Dropdown']"));
       selectElementByValue(selectElement , "Drop down item 1");

       selectElementByValue(selectElement, "Drop down item 5");


    }

    public static void moveToElement(WebDriver driver, WebElement elementToMoveTo){
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToMoveTo);
    }
    public static void doubleClick(WebDriver driver , WebElement elementToClickOn){
        Actions actions = new Actions(driver);
        actions.doubleClick(elementToClickOn);
    }
    public static void moveToElementAndDoubleClick(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.doubleClick(element);
    }
    public static void selectElementByValue(WebElement element, String valueToSelect){
        Select select = new Select(element);
        select.selectByValue(valueToSelect);
    }


}
