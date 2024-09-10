package Day12_SeleniumFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SauceDemoLogin {
    static WebDriver driver = Driver.getDriver();



    public static void main(String[] args) {
        verifyMainLabel();
        verifyLockedOutUser();
    }



    /**
     *     Test Case 1:
     *     Navigate to https://www.saucedemo.com/
     *     Enter “standard_user” into username and “secret_sauce” into passwords
     *     Verify that “Swag Labs” lable is displayed
     */

    public static void verifyMainLabel() {
        System.out.println("Test Case 1 started ");
        //WebDriver driver = new ChromeDriver();
        driver.get(ConfigurationReader.getPropertyValue("baseUrl"));
        //enter username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //verify that label
        WebElement label = driver.findElement(By.xpath("(//div[.='Swag Labs'])[2]"));
        if (label.isDisplayed()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        System.out.println("Test Case 1 Ended ");
        Driver.closeDriver();//now the driver is null
    }


    /**
     *     Test Case 2:
     *     Navigate to https://www.saucedemo.com/
     *     Enter “locked_out_user” into username and “secret_sauce” into passwords
     *     Verify that The Error message “Epic sadface: Sorry, this user has been locked out.” is displayed
     */

    public static void verifyLockedOutUser(){
        driver = Driver.getDriver();
        System.out.println("Test Case 2 started ");
        driver.get(ConfigurationReader.getPropertyValue("baseUrl"));
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("locked_out_user");
        //enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Error locked element
        WebElement errorLockedOutMessage = driver.findElement(By.xpath("//h3[.='Epic sadface: Sorry, this user has been locked out.']"));
        String lockedOutText = errorLockedOutMessage.getText();
        if (lockedOutText.equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


        boolean lockedOutMessageDisplayed = errorLockedOutMessage.isDisplayed();
        if (lockedOutMessageDisplayed) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        System.out.println("Test Case 2 ended ");
        Driver.closeDriver();
    }

}
