package Day9_SeleniumFunctionsPart5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandleDemo {
    public static void main(String[] args) {
        windowHandleExample();
    }

    public static void windowHandleExample(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/windows-test.html");
        WebElement linkElement = driver.findElement(By.xpath("//a[@id='gobasicajax']"));
        linkElement.click();//this will open a new tab

        String currentWindow = driver.getWindowHandle();
        System.out.println(currentWindow);


        //


        WebElement h1 = driver.findElement(By.xpath("//h1[text()='Basic Ajax Example']"));
        System.out.println(h1.getText());

    }


}
