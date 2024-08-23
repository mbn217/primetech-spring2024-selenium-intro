package Day5_CssSelectorFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFunctions {
    public static void main(String[] args) throws InterruptedException {
        //usingGetAttributeExample();
        //usingGetCssAndTagName();
        //usingKeysClassExample();
        //usingDownButtonInKeysClass();
        navigateFunctions();
    }

    public static void usingGetAttributeExample(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/?_rdr");

        WebElement facebookImage = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
        System.out.println("Getting facebook image text --> " + facebookImage.getText());

        System.out.println("Getting faccebook image text using getAttribute --> "+ facebookImage.getAttribute("alt"));

        System.out.println("Getting src value --> " + facebookImage.getAttribute("src"));

        WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[text()='Forgot password?']"));
        System.out.println("The Link for forgot pass is : " + forgotPasswordLink.getAttribute("href"));


    }
    public static void usingGetCssAndTagName(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/?_rdr");

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        System.out.println("The color is " + emailInput.getCssValue("color")
                            + " And the height of the element is " + emailInput.getCssValue("height"));

        System.out.println("The tag name of the email input is : " + emailInput.getTagName());



    }

    public static void usingKeysClassExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/");
        WebElement searchField = driver.findElement(By.xpath("//textarea[@id='sb_form_q']"));

        //Option 1 to write into a field is using sendKeys()
        //Option 2 is using Keys class
        searchField.sendKeys(Keys.chord("Selenium"));
        Thread.sleep(4000);
        //Control + A , Control + X
        searchField.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        Thread.sleep(4000);
        searchField.sendKeys(Keys.chord(Keys.COMMAND, "x"));

    }

    public static void usingDownButtonInKeysClass() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/index.html");

        WebElement htmlPage = driver.findElement(By.xpath("/html"));
        htmlPage.click();//this will make driver focus on the page

        for (int i = 0; i < 15; i++) {
            htmlPage.sendKeys(Keys.DOWN);
            Thread.sleep(1000);
        }

    }


    public static void navigateFunctions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //Option 1  to navigate to a site
        //driver.get("https://testpages.eviltester.com/styled/index.html");

        //Option2 to navigate to a site
        driver.navigate().to("https://testpages.eviltester.com/styled/index.html");

        //navigate to about page
        WebElement aboutLink = driver.findElement(By.xpath("//a[.='About' ]"));
        aboutLink.click();
        Thread.sleep(3000);
        //navigate back to orignal page
        driver.navigate().back();
        Thread.sleep(3000);
        //navigate forward to the about page
        driver.navigate().forward();
        //refresh the page
        driver.navigate().refresh();

    }

}
