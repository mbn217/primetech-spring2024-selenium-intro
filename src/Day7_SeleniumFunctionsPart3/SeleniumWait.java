package Day7_SeleniumFunctionsPart3;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWait {
    public static void main(String[] args) {
        //implicitWaitExample();
        explicitWaitExample();
    }

    public static void implicitWaitExample(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");


        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        driver.quit();
    }
    public static void explicitWaitExample(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        //WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        //username.sendKeys("standard_user");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='user-namexyz']"))));

        driver.quit();


    }


    public static void fluentWaitExample(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        //WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        //username.sendKeys("standard_user");

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20))
                        .pollingEvery(Duration.ofSeconds(5))
                                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='user-name']"))));


        driver.quit();


    }





}
