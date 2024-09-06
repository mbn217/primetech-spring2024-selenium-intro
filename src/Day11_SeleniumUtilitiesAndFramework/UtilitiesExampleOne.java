package Day11_SeleniumUtilitiesAndFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.SeleniumUtils;

public class UtilitiesExampleOne {
    public static void main(String[] args) throws InterruptedException {
        //testCaseOne();
        //testCaseTwo();
        testCaseThree();

    }
    public static void testCaseOne() throws InterruptedException {
        /**
         * go to https://testpages.eviltester.com/styled/basic-html-form-test.html
         * select by value "Drop Down Item 4"
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        WebElement selectDropDown = driver.findElement(By.xpath("//select[@name='dropdown']"));
//        Select select = new Select(selectDropDown);
//        select.selectByValue("dd4");
        //We can use the utility method we created inside SeleniumUtils class
        SeleniumUtils.selectByValueFromDropDown(selectDropDown,"dd4");

        Thread.sleep(4000);
        driver.quit();

    }

    public static void testCaseTwo() throws InterruptedException {
        /**
         * go to http://practice.primetech-apps.com/practice/practice-forms
         * select by value "California"
         */
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.primetech-apps.com/practice/practice-forms");
        WebElement selectDropDownElement = driver.findElement(By.xpath("//select[@id='state']"));
//        Select select = new Select(selectDropDownElement);
//        select.selectByValue("California");
        //We can use the utility method we created inside SeleniumUtils class
        SeleniumUtils.selectByValueFromDropDown(selectDropDownElement , "California" );
        Thread.sleep(4000);
        driver.quit();

    }

    public static void testCaseThree() throws InterruptedException {
        /**
         * go to http://practice.primetech-apps.com/practice/drag-and-drop
         * drag and drop items from left box to right box
         * 9:05
         */
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
        WebElement textSource = driver.findElement(By.xpath("//a[@id='text']"));
        WebElement textAreaSource = driver.findElement(By.xpath("//a[@id='textarea']"));
        WebElement numberSource = driver.findElement(By.xpath("//a[@id='Number']"));

        //target element
        WebElement targetElement = driver.findElement(By.xpath("//div[@id='dropzone']"));

//        Actions actions = new Actions(driver);
//        actions.dragAndDrop(textSource , targetElement).build().perform();
//        actions.dragAndDrop(textAreaSource , targetElement).build().perform();
//        actions.dragAndDrop(numberSource, targetElement).build().perform();
        //Now we can use the utility  method that we just created
        SeleniumUtils.dragAndDrop(driver, textSource , targetElement);
        SeleniumUtils.dragAndDrop(driver, textAreaSource , targetElement);
        SeleniumUtils.dragAndDrop(driver, numberSource , targetElement);


        Thread.sleep(3000);

        driver.quit();




    }




}
