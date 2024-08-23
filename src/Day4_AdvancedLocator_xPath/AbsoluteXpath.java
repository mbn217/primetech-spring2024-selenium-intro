package Day4_AdvancedLocator_xPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbsoluteXpath {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/basic-web-page-test.html");

        WebElement p1 = driver.findElement(By.xpath("/html/body/div/div[3]/p[1]"));
        System.out.println(p1.getText());





    }


}
