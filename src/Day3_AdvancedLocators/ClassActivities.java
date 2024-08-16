package Day3_AdvancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassActivities {
    public static void main(String[] args) {
        //Here I will be running my test cases
        //testCase1();

        testCase2();

    }

    public static void testCase1(){
        //Here is going to be the code for the Test Case 1 Activity
        /**
         * Test case 1
         *     go to facebook.com
         *      find the Email or phone number field and type Automation
         *      find the Password field and type Automation
         *      find the Login button and click on it.
         *      close the browser
         */
        //Create driver object
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        //find email field
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("Automation");

        //find password field
        WebElement passwordField = driver.findElement(By.name("pass"));
        passwordField.sendKeys("Automation");

        //find login field
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();


    }


    public static void testCase2(){
        /**
         * Test case 2
         *     go to facebook.com
         *      find the Create New Account button and click on it
         *      find the FirstName,  LastName, Email and Password fields and type Automation
         *      find the Sign Up button and click on it.
         *      --until 8:50pm
         */

        //Create driver Object
        WebDriver driver = new ChromeDriver();
        //Navigate to facebook
        driver.get("https://www.facebook.com");
        //Find Create New Account button and click on it
        WebElement createNewAccountButton = driver.findElement(By.linkText("Create new account"));
        createNewAccountButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //find the FirstName fields and type Automation
        WebElement firstNameField = driver.findElement(By.name("firstname"));
        firstNameField.sendKeys("Automation");

        // find LastName fields and type Automation
        WebElement lastNameField = driver.findElement(By.name("lastname"));
        lastNameField.sendKeys("Automation");

        // find Emailfields and type Automation
        WebElement emailField = driver.findElement(By.name("reg_email__"));
        emailField.sendKeys("Automation");


        // find Password fields and type Automation
        WebElement passField = driver.findElement(By.name("reg_passwd__"));
        passField.sendKeys("Automation");

        //Find and click on Sign up button
        WebElement signUpButton = driver.findElement(By.name("websubmit"));
        signUpButton.click();


    }



}
