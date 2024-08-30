package Day8_SeleniumFunctionPart4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsExamples {
    public static void main(String[] args) throws InterruptedException {
        //alertExamples();
        //testCase1();
        testCase2();

    }

    public static void alertExamples() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/alerts/alert-test.html");
        WebElement btn1 = driver.findElement(By.xpath("//input[@value='Show alert box']"));
        btn1.click();
        Thread.sleep(4000);
        //Handle alert by accepting it (Clicking on Ok button)
        driver.switchTo().alert().accept();


        WebElement btn2 = driver.findElement(By.xpath("//input[@value='Show confirm box']"));
        btn2.click();
        Thread.sleep(4000);
        //We can dismiss the popup ( clicking on Cancel button)
        driver.switchTo().alert().dismiss();


        WebElement btn3 = driver.findElement(By.xpath("//input[@value='Show prompt box']"));
        btn3.click();
        Thread.sleep(4000);
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
        Thread.sleep(1000);

        driver.switchTo().alert().sendKeys("Automation Using Selenium");


        Thread.sleep(1000);
        driver.switchTo().alert().accept();


        //You can als creatre a reference variable of Alert type and then use the RV(reference variable/object)
        //to sendkeys / accept /dismiss
        Alert myAlert =  driver.switchTo().alert();

    }

    public static void testCase1() throws InterruptedException {
        /**
         * Test case 1
         * go to https://demoqa.com/alerts
         * Click on the first ‘Click me’  button and Accept the alert.
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        WebElement btn1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
        btn1.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //Option 2
        //Alert alert = driver.switchTo().alert();
        //alert.accept();
    }

    public static void testCase2() throws InterruptedException {
        /**
         * Test case 2
         * go to https://demoqa.com/alerts
         * Click on the second ‘Click me’ button and get the text of it.
         * Then verify if the text equals to “This alert appeared after 5 seconds” then Accept the alert.
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        /**
         * implicit wait is trying to wait on specific element but we are dealing with Alert
         */
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement btn2 = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        btn2.click();
        //5 second is needed for the pop up to display
        Thread.sleep(7000);

        //Explicit wait will solve this
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        driver.quit();
    }

}
