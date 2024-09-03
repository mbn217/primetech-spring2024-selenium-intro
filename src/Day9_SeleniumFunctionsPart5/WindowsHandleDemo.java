package Day9_SeleniumFunctionsPart5;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsHandleDemo {
    public static void main(String[] args) {
        //windowHandleExample();
        //windowHandleExample2();
        //testCase1();
        testCase2();
    }

    public static void windowHandleExample(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/windows-test.html");
        WebElement linkElement = driver.findElement(By.xpath("//a[@id='gobasicajax']"));
        linkElement.click();//this will open a new tab

        // Store the main window handle -- the first tab
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println(mainWindowHandle);


        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles){
            //if the handle is not equal to the main handle (main tab)
            if(!handle.equals(mainWindowHandle)){
                driver.switchTo().window(handle);
            }
        }


        WebElement h1 = driver.findElement(By.xpath("//h1[text()='Basic Ajax Example']"));
        System.out.println(h1.getText());



        //We want to switch back to main tab
        driver.switchTo().window(mainWindowHandle);
        WebElement h1MainTab = driver.findElement(By.xpath("//h1[text()='Windows Links and Examples']"));
        System.out.println(h1MainTab.getText());

    }

    public static void windowHandleExample2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/windows-test.html");
        WebElement linkElement = driver.findElement(By.xpath("//a[@id='gobasicajax']"));
        linkElement.click();//this will open a new tab

        // Store the main window handle -- the first tab
        String mainWindowHandle = driver.getWindowHandle();


        // Get all window handles
        ArrayList<String> allWindowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindowHandles.get(1));




        WebElement h1 = driver.findElement(By.xpath("//h1[text()='Basic Ajax Example']"));
        System.out.println(h1.getText());



        //We want to switch back to main tab
        driver.switchTo().window(allWindowHandles.get(0));
        WebElement h1MainTab = driver.findElement(By.xpath("//h1[text()='Windows Links and Examples']"));
        System.out.println(h1MainTab.getText());
    }


    public static void testCase1(){
        /**
         * Test case 1
         * go to http://practice.primetech-apps.com/practice/browser-windows
         * Click on ‘New Tab’ button.
         * Then get the window handles and print what are they.
         *
         */
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.primetech-apps.com/practice/browser-windows ");
        WebElement newTabButton = driver.findElement(By.xpath("//a[@id='newTab']"));
        newTabButton.click();

        ArrayList<String> allWindows = new ArrayList<>(driver.getWindowHandles());
         for (String tab : allWindows){
             System.out.println("The Id ---> " + tab);
         }








        
    }

    public static void testCase2(){
        /**
         * Test case 2
         * go to http://practice.primetech-apps.com/practice/browser-windows
         * 1. Get the main window ID and store it in a String called mainWindowId,
         * 2. Click on the ‘New Tab’ button
         * 3. Get window IDs and store it into a List
         * 4. Get the first window ID from the List and Verify it matches with the main window id in step 1.
         * Then get the second window id and store it in variable called secondWindowId.
         * 5. Switch to the second window
         *  6. Verify that there is a button called ‘New Tab’
         * 7. Close the window,  Switch back to the main window, Verify you are on the main window.
         *
         */

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.primetech-apps.com/practice/browser-windows");
        String mainWindowId = driver.getWindowHandle();
        WebElement btn = driver.findElement(By.xpath("//a[@id='newTab']"));
        btn.click();

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        if(mainWindowId.equals(windowHandles.get(0))){
            System.out.println("They are same");
        } else{
            System.out.println("they are not same");
        }

        //getting second tab id
        String secondWindowTabId = windowHandles.get(1) ;
         //switching to second tab
        driver.switchTo().window(secondWindowTabId);



    }
}
