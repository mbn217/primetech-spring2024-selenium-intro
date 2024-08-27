package Day6_SeleniumFunctionsPart2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonAndCheckboxes {
    public static void main(String[] args) {
        //isSelected();
        isDisplayed();
    }
    public static void isSelected(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        //To verify if a checkbox is seleted by default we use isSelected()
        WebElement checkbox = driver.findElement(By.xpath("//input[@value='cb3']"));
        System.out.println(checkbox.isSelected());//true

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@value='cb2']"));
        System.out.println(checkbox2.isSelected()); //false


        WebElement radiobutton2 = driver.findElement(By.xpath("//input[@value='rd2']"));
        System.out.println(radiobutton2.isSelected()); //true
        driver.quit();
    }

    public static void isDisplayed(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        System.out.println(h1.isDisplayed());
        driver.quit();

    }
}
