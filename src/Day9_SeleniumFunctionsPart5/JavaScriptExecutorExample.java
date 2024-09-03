package Day9_SeleniumFunctionsPart5;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        //scrollToElementExample();
        clickOnElementExample();
    }

    public static void scrollToElementExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement checkThisBtn = driver.findElement(By.xpath("//button[text()='Check this']"));
        //Using Keys Class
        //checkThisBtn.sendKeys(Keys.DOWN);

        //Use JavascriptExecutor
        Thread.sleep(2000);
        JavascriptExecutor jsExecutor =   (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", checkThisBtn);

    }

    public static void clickOnElementExample(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        WebElement alertButton = driver.findElement(By.xpath("//input[@id='alert1']"));


        //Highlight the element
        highlightElement(driver,alertButton);

        //Options1
        //alertButton.click(); in some cases this wont work , then you will need to use JavascriptExecutor

        //Option 2
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", alertButton);






    }

    /**
     * highlight on element using javascriptExecutor
     * @param driver instance of the browser
     * @param element the element we want to highlight
     */
    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Execute JavaScript code to apply a border and change background color
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red; background-color: yellow;');", element);
        // Wait for a short duration to see the highlighted effect (optional)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Execute JavaScript code to remove the highlighting
        js.executeScript("arguments[0].setAttribute('style', 'border: none; background-color: none;');", element);
    }


}
