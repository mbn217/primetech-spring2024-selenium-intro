package Day6_SeleniumFunctionsPart2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UsingTables {
    public static void main(String[] args) {
        //tableExample1();
        tableExample2();
    }


    public static void tableExample1(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://testpages.eviltester.com/styled/tag/table.html");
        //We need to identify the entire table
        WebElement table = driver.findElement(By.xpath("//div[@id='tablehere']"));

        //we need to identify which cell we need from that table
        WebElement cell = table.findElement(By.xpath("(//td)[3]"));
        System.out.println(cell.getText());

        driver.quit();
    }

    public static void tableExample2(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://testpages.eviltester.com/styled/tag/table.html");

        //Entire table means column names and the data
        //table header  --> th
        //table data  --> td
        //table rows  --> tr
        List<WebElement> tableHeaders = driver.findElements(By.xpath("//th"));
        for (WebElement header : tableHeaders){
            //System.out.println(header.getText());
        }
        System.out.println("---------------------------------------");
        List<WebElement> tableData = driver.findElements(By.xpath("//td"));
        for (WebElement cell : tableData){
            //System.out.println(cell.getText());
        }
        System.out.println("---------------------------------------");
        List<WebElement> table1 =driver.findElements(By.xpath("//table"));
        //System.out.println(table1.get(0).getText());


        List<WebElement> rows = driver.findElements(By.xpath("//tr"));
        //System.out.println(rows.get(0).getText());
        //System.out.println(rows.get(1).getText());

        //Complex options 1 - Nested loop to print table headers and data

        // Retrieve and print table headers
        List<WebElement> headers = driver.findElements(By.tagName("th"));
        for (WebElement header : headers) {// Print each header
            System.out.print(header.getText() + "\t"); // Print header with a tab space
        }
        System.out.println(); // Move to the next line after headers

        // Retrieve and print each row's data in the table (except headers) using a nested loop
        List<WebElement> rows2 = driver.findElements(By.tagName("tr"));
        for (WebElement row : rows2) {// For each row
            // Retrieve and print each cell data
            List<WebElement> cells = row.findElements(By.tagName("td"));
            // For each cell in the row (each column) print the cell data
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t"); // Print each cell data with a tab space
            }
            System.out.println(); // Move to the next line after each row
        }



        //Complex options 2 - Single loop to print table headers and data

        // Retrieve all rows in the table
        List<WebElement> rows3 = driver.findElements(By.tagName("tr"));
        boolean headersPrinted = false; // Flag to ensure headers are printed only once

        // For each row in the table print the headers and data
        for (WebElement row : rows3) {
            // Check if headers have been printed
            if (!headersPrinted) {// If headers have not been printed
                // Retrieve and print table headers
                List<WebElement> headers3 = row.findElements(By.tagName("th"));
                for (WebElement header : headers3) {
                    System.out.print(header.getText() + "\t"); // Print header with a tab space
                }
                System.out.println(); // Move to the next line after headers
                headersPrinted = true; // Set the flag to true to avoid printing headers again
            }

            // Retrieve and print each row's data
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t"); // Print each cell data with a tab space
            }
            System.out.println(); // Move to the next line after each row
        }




        driver.quit();
    }

}
