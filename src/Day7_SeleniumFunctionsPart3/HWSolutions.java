package Day7_SeleniumFunctionsPart3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HWSolutions {
    public static void main(String[] args) {
        //testCase1();
        testCase2();
    }

    public static void testCase1(){
        /**
         * Test case 2
         * go to https://saucedemo.com
         * log in with username = standard_user   password = secret_sauce
         * find all the results. print the price of each result.
         * Hint: loop through the list, get index and get text
         */
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        //click on login button
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();

        List<WebElement> listOfPrices =driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        for (WebElement price : listOfPrices){
            //System.out.println(price.getText());
        }

        for (int i = 0; i < listOfPrices.size() ; i++) {
            String price = listOfPrices.get(i).getText();
            System.out.println("At index --> " + i + " the price is --> " + price);
        }


    }

    public  static void testCase2(){
        /**
         * Test case 2.
         * go to https://designsystem.digital.gov/components/radio-buttons/
         * Find those available radio buttons under Default.
         * Check if it’s displayed and enabled,  if true, check if it’s selected,
         * if false select the button and check if it’s selected.
         */

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://designsystem.digital.gov/components/radio-buttons/");

        //find the radio button and check if they are displayed and enabled
        List<WebElement> radioButtonList = driver.findElements(By.xpath("//input[@class='usa-radio__input']"));
        //Is displayed method works on text

        for (WebElement radio : radioButtonList){
            System.out.println("Is radio button displayed?? " + radio.isEnabled());
        }

        List<WebElement> radioButtonTextList = driver.findElements(By.xpath("//input[@class='usa-radio__input']/following-sibling::label"));
        for (WebElement radioText : radioButtonTextList){
            System.out.println("Is radio title displayed ?? " + radioText.isDisplayed());
            System.out.println("The Text is ---> " + radioText.getText());
        }


    }

}
