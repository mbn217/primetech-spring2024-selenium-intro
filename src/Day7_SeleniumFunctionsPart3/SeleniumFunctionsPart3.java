package Day7_SeleniumFunctionsPart3;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SeleniumFunctionsPart3 {
    public static void main(String[] args) throws InterruptedException {
        usingSelect();
    }

    public static void usingSelect() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        Thread.sleep(3000);
        WebElement selection = driver.findElement(By.xpath("//select[@name='dropdown']"));
        //We can use Select by index ( index for the first item is 0)
        Select selectItem = new Select(selection);
        selectItem.selectByIndex(0);
        Thread.sleep(3000);
        selectItem.selectByIndex(1);
        Thread.sleep(3000);

        //Option 2 : we can use selectByValue
        selectItem.selectByValue("dd6"); //value will come from html, you have to identify it from the value attribute

        Thread.sleep(3000);
        //Option 3 : We can use Select by visible Text
        selectItem.selectByVisibleText("Drop Down Item 5");

        Thread.sleep(3000);
        //getFirstSelectedOption()
        WebElement option = selectItem.getFirstSelectedOption(); // return an element of the option that was selected
        System.out.println(option.getText());


        //use getOptions
        List<WebElement> allOptions = selectItem.getOptions();

        for (WebElement optionItem : allOptions){
            System.out.println(optionItem.getText());
        }




    }
}
