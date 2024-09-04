package Day10_SelniumFunctionsPart6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {
    public static void main(String[] args) throws InterruptedException {
        //doubleClickExample();
        //dragAndDropExample();
        //onContextExample();
        //onMouseOverExample();
        onMouseLeaveExample();
    }

    public static void doubleClickExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/events/javascript-events.html");
        Thread.sleep(3000);

        //To double click on Element
        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[@id='ondoubleclick']"));

        Actions action = new Actions(driver);
        action.doubleClick(doubleClickBtn).build().perform();//recommended way

        driver.quit();
    }

    public static void dragAndDropExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/drag-drop-javascript.html");
        Thread.sleep(3000);
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable1']"));
        WebElement destination = driver.findElement(By.xpath("//div[@id='droppable1']"));


        Actions actions = new Actions(driver);
        //We use dragAndDrop method in case we need to drag an element from one location to another
        actions.dragAndDrop( source  ,  destination  ).build().perform();

        //Identify the source and destination of the second boxes and perform a drag and drop
        WebElement source2 = driver.findElement(By.xpath("//div[@id='draggable2']"));
        WebElement destination2 = driver.findElement(By.xpath("//div[@id='droppable2']"));

        //actions.dragAndDrop(source2,destination2).build().perform();

        //option 2
        actions.clickAndHold(source2).moveToElement(destination2).release().build().perform();
        driver.quit();
    }

    public static void onContextExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/events/javascript-events.html");
        Thread.sleep(3000);
        WebElement onContextBtn = driver.findElement(By.xpath("//button[@id='oncontextmenu']"));

        Actions actions = new Actions(driver);
        actions.contextClick(onContextBtn).build().perform();

        driver.quit();
    }

    public static void onMouseOverExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/events/javascript-events.html");
        Thread.sleep(3000);

        WebElement onMouseOver = driver.findElement(By.xpath("//button[@id='onmouseover']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(onMouseOver).build().perform();
        driver.quit();
    }

    public static void onMouseLeaveExample() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/events/javascript-events.html");
        Thread.sleep(3000);

        /**
         * You need to trigger the event on the button called onMouseLeave
         * Hint: moveToElement()
         * 9:10pm
         */
        WebElement onMouseLeaveBtn = driver.findElement(By.xpath("//button[@id='onmouseleave']"));
        Actions actions = new Actions(driver);
        //scroll to element using action class
        WebElement anchortag = driver.findElement(By.xpath("//a[.='EvilTester.com']"));
        actions.scrollToElement(anchortag).build().perform();


        Thread.sleep(3000);
        //we move the mouse into the button
        actions.moveToElement(onMouseLeaveBtn).build().perform();

        //we have to move the focus from the button to somewhere else
        WebElement htmlpage = driver.findElement(By.xpath("//html"));
        actions.moveToElement(htmlpage).build().perform();

        driver.quit();


    }



}
