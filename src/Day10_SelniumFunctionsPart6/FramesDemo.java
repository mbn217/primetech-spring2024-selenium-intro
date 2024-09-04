package Day10_SelniumFunctionsPart6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FramesDemo {
    public static void main(String[] args) {
        frameExample();
    }

    public static void frameExample(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/frames/frames-test.html");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //We have to tell selenium to switch to a different frame
        //Option1 to use id/name
        //driver.switchTo().frame("middle");

        //option2 to use WebElement
        //WebElement frameMiddle = driver.findElement(By.xpath("//frame[@name='middle']"));
        //driver.switchTo().frame(frameMiddle);

        //Option3 to use index
        driver.switchTo().frame(2);


        WebElement item = driver.findElement(By.xpath("//li[@id='middle0']"));
        System.out.println(item.getText());

        //we have to switch back to original frame
        driver.switchTo().defaultContent();//this should switch back to original html root

        driver.switchTo().frame("top");
        WebElement h1Tag = driver.findElement(By.xpath("//h1[.='Nested Frames Example']"));
        System.out.println(h1Tag.getText());

    }

}
