package Day11_SeleniumUtilitiesAndFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo {
    public static void main(String[] args) {
        //additionOfTwoNumber()
//        int num = 8;
//        int num2 = 10;
//        System.out.println(num + num2);

        additionOfTwoNumber(8,10);
//        int n1 = 15;
//        int n2 = 20;
//        System.out.println(n1 + n2);
        additionOfTwoNumber(15,20);


    }

    //Usually utility methods are static because they do not need a separate instance everytime to call them
    //They can just be called using Class Name
    public static void additionOfTwoNumber(int number, int number2){
        System.out.println(number + number2);
    }


}
