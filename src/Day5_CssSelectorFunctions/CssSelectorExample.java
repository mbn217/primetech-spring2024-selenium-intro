package Day5_CssSelectorFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorExample {
    public static void main(String[] args) {
        //exampleOne();
        exampleTwo();
    }

    public static void exampleOne(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/basic-web-page-test.html");

        WebElement usingShortId = driver.findElement(By.cssSelector("#para1"));
        System.out.println("Using Id short cut : paragraph is: " + usingShortId.getText());

        WebElement usingLongId = driver.findElement(By.cssSelector("p[id='para1']"));
        System.out.println("Using Long Id  : paragraph is: " + usingLongId.getText());

        System.out.println("---------------------------------------------");

        WebElement usingLongClass = driver.findElement(By.cssSelector("p[class='main']"));
        System.out.println("Using long class  : paragraph is: " + usingLongClass.getText());

        WebElement usingShortClass = driver.findElement(By.cssSelector(".main"));
        System.out.println("Using short class  : paragraph is: " + usingShortClass.getText());
        driver.quit();
    }

    public static void exampleTwo(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        WebElement userNameField= driver.findElement(By.cssSelector("input[name='username']"));
        userNameField.sendKeys("primetechuser");
        driver.quit();


    }

}
