package Day4_AdvancedLocator_xPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWReview {
    public static void main(String[] args)  {

        testCase2();

    }

    public static void testCase2() {
        /**
         * go to indeed.com
         * get the current URL and store it in a variable called homeURL.
         * get the website title and store it in a variable homeTitle.
         * find the input field for “Job title,Keywords” and type SDET
         * find the Search button and click on it.
         * get the current URL and store it a variable searchURL.
         * get the website title and store it in a variable searchTitle.
         * verify that searchURL does not equal to homeURL and contains the search criteria.
         * verify that searchTitle does not equal to homeTitle and has the search criteria.
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.indeed.com/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Somthing happend here");
        }


        //get current url and assign it to a variable
        String homeUrl = driver.getCurrentUrl();
        System.out.println("Original Home URL: " + homeUrl);

        String homeTitle = driver.getTitle();
        System.out.println("Original Home Title: " + homeTitle);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("SDET");

        WebElement searchBtn = driver.findElement(By.className("yosegi-InlineWhatWhere-primaryButton"));
        searchBtn.click();



        String newSearchURL = driver.getCurrentUrl();
        System.out.println("New Current URL is: " + newSearchURL);

        String newTitle = driver.getTitle();
        System.out.println("New Title is: " + newTitle);

        //verify that searchURL does not equal to homeURL and contains the search criteria.
        //!= this will compare the address of the object in the memory
        if(!homeUrl.equals(newSearchURL) &&  newSearchURL.contains("SDET")){
            System.out.println("TRUE, URLS do NOT match which means we clicked on search button successfully");
        }else{
            System.out.println("False, URLS did not match or SDET is not inside the new url");
        }
        //verify that searchTitle does not equal to homeTitle and has the search criteria.

        if (!homeTitle.equals(newTitle) && newTitle.toLowerCase().contains("SDET".toLowerCase()) ){
            System.out.println("True");
        }else{
            System.out.println("False");
        }



    }


}
