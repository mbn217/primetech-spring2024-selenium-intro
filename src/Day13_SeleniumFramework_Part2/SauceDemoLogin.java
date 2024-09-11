package Day13_SeleniumFramework_Part2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LandingPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SauceDemoLogin {
    static WebDriver driver = Driver.getDriver();
    static LoginPage loginPage;
    static LandingPage landingPage;




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
        loginPage = new LoginPage();
        landingPage = new LandingPage();
        System.out.println("Test Case 1 started ");
        //WebDriver driver = new ChromeDriver();
        driver.get(ConfigurationReader.getPropertyValue("baseUrl"));
        //enter username
        loginPage.username.sendKeys("standard_user");
        //enter password
        loginPage.password.sendKeys("secret_sauce");
        //click on login button
        loginPage.loginButton.click();
        //verify that label
        if (landingPage.mainLabel.isDisplayed()) {
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
        loginPage = new LoginPage();
        driver = Driver.getDriver();
        System.out.println("Test Case 2 started ");
        driver.get(ConfigurationReader.getPropertyValue("baseUrl"));
        loginPage.username.sendKeys("locked_out_user");
        //enter password
        loginPage.password.sendKeys("secret_sauce");
        //click on login button
        loginPage.loginButton.click();
        //Error locked element

        String lockedOutText = loginPage.errorMessageLabel.getText();
        if (lockedOutText.equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


        boolean lockedOutMessageDisplayed = loginPage.errorMessageLabel.isDisplayed();
        if (lockedOutMessageDisplayed) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        System.out.println("Test Case 2 ended ");
        Driver.closeDriver();
    }

}
