package Day3_AdvancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByTagName {

    public static void main(String[] args) {

        //Create driver Object
        WebDriver driver = new ChromeDriver();
        //Navigate to facebook
        driver.get("https://www.facebook.com");
        //finding element using tagname
        WebElement element = driver.findElement(By.tagName("h2"));
        //retrieving the text from the h2 element
        String h2Text = element.getText();
        //printing the text
        System.out.println(h2Text);

    }

}
