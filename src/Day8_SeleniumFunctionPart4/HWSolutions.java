package Day8_SeleniumFunctionPart4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HWSolutions {
    public static void main(String[] args) {
        //task1();
        task2();
    }
    public static void task1(){
        /**
         * Task 1: Select from Dropdown
         * go to https://omayo.blogspot.com/
         * verify that by default the “Older Newsletters” is selected from the dropdown
         * get all the option available in the dropdown
         * verify that the list is matching with what is in the requirement
         * (assume the same list in the UI is what in the requirement)
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='drop1']"));
        Select select = new Select(dropDown);
        WebElement defaultSelected = select.getFirstSelectedOption();
        System.out.println(defaultSelected.getText());
        System.out.println("-------------------------");
        List<WebElement> list = select.getOptions();
        List<String> actualListOfDropDownFromUI = new ArrayList<>();
        for (WebElement element : list){
            String textOfTheDropDown = element.getText();
            System.out.println(textOfTheDropDown);//printing the text of the element
            actualListOfDropDownFromUI.add(textOfTheDropDown);//we adding the text of the element into the array
        }

        select.selectByValue("def"); //selecting a different value than the default one


        //All options that are coming from requirement document
        List<String> expectedListOfDropDowns = List.of("Older Newsletters","doc 1","doc 2","doc 3","doc 4");


        for (int i = 0; i < expectedListOfDropDowns.size() ; i++) {
            if (expectedListOfDropDowns.get(i).equals(actualListOfDropDownFromUI.get(i))){
                System.out.println("Option " + i + " is matching");
            }else{
                System.out.println("Option " + i + " is not matching" +
                        " Actual Options is["+ actualListOfDropDownFromUI.get(i) + "] vs the Expected [" +
                        expectedListOfDropDowns.get(i) +"]");
            }
        }


    }


    public static void task2(){
        /**
         * Task 3: Using Waits
         * go to https://www.hyrtutorials.com/p/waits-demo.html
         * Click on Add Textbox1
         * Enter a value “test” into the Textbox1 input box once its displayed
         * Click on Add Textbox2
         * Enter a value “test” into the Textbox2 input box once its displayed
         * Hint: Use either implicit wait or explicit wait
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
        //using implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement btn1 = driver.findElement(By.xpath("//button[@id='btn1']"));
        btn1.click();
        //textbox1 is going to take 5 seconds
        //WebElement textbox1 = driver.findElement(By.xpath("//h3[text()='Show the textboxes here:']/input[1]"));
        //textbox1.sendKeys("Automation");

        //-------------- Example using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Show the textboxes here:']/input[1]")));
        driver.findElement(By.xpath("//h3[text()='Show the textboxes here:']/input[1]")).sendKeys("Automation");


        //---------------


        WebElement btn2 = driver.findElement(By.xpath("//button[@id='btn2']"));
        btn2.click();
        //textbox2 is going to take 10 seconds
        //WebElement textbox2 = driver.findElement(By.xpath("//h3[text()='Show the textboxes here:']/input[2]"));
        //textbox2.sendKeys("Selenium");

        //--------------- Example using explicit wait
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Show the textboxes here:']/input[2]")));
        driver.findElement(By.xpath("//h3[text()='Show the textboxes here:']/input[2]")).sendKeys("Selenium");

        //---------------

    }


}
