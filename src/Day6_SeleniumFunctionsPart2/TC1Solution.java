package Day6_SeleniumFunctionsPart2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1Solution {

    public static void main(String[] args) {
        testCase1();
    }


    public static void testCase1(){
        /**
         * Test case 1: (USE CSS Selector)
         *
         * Go to indeed.com
         * Find the Where field and get value of attribute ‘value’, then verify it’s based on your current location.
         * Find the Where field and get css value of color, then print it out.
         * Find the Where field and get tag name, then verify the tag name is equals to “input”.
         */
        //Requirement
        String expectedLocation = "Bowie, MD";
        String expectedTagName = "input";


        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.indeed.com/");
        WebElement locationElement = driver.findElement(By.xpath("//input[@id='text-input-where']"));
        String actualLocation= locationElement.getAttribute("value");

        if (expectedLocation.equals(actualLocation)){
            System.out.println("Location match");
        }else{
            System.out.println("Location doesn't match");
        }

        //To get the CSS value of specific property we use getCssValue()
        String inputFieldColor =  locationElement.getCssValue("color");
        System.out.println( inputFieldColor );

        //To get the tag name of the element we use getTagName()
        String actualTagName = locationElement.getTagName();

        if (expectedTagName.equals(actualTagName)){
            System.out.println("Tag name matches requirement");
        }else{
            System.out.println("Tag name did not match with the requirement because the actual tag  is { " +
                    actualTagName + " } but the expected tag is { " + expectedTagName + " }");
        }
    }



}
