package Day6_SeleniumFunctionsPart2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UsingWebElements {
    public static void main(String[] args) {
        //example1();
        //example2();
        testCase1Solution();
    }

    public static void example1(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://testpages.eviltester.com/styled/basic-web-page-test.html");
       List<WebElement> allParagraphs = driver.findElements(By.xpath("//p"));


       for(WebElement element :  allParagraphs){
           System.out.println(element.getText());
           System.out.println("------------------------");
       }

    }

    public static void example2(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://testpages.eviltester.com/styled/index.html");

        List<WebElement> allLinks    = driver.findElements(By.xpath("//a"));

        for (WebElement link :   allLinks   ){
            System.out.println(link.getAttribute("href"));
            System.out.println("----------------------------");
        }
        driver.quit();

    }

    public static void testCase1Solution(){
        /**
         * Test case 1
         *     go to https://saucedemo.com
         *      log in with username = standard_user   password = secret_sauce
         *      find all the results and get them in a list, and print the size of the list.
         */
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        List<WebElement> results =  driver.findElements(By.xpath("//div[@class='inventory_item']"));

        //printing the size of the array
        System.out.println(results.size());

        driver.quit();








    }



}
