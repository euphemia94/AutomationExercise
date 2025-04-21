package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Cart {
    WebDriver driver;
    //constructor
    public Cart(WebDriver driver){
        this.driver = driver;
    }
    //go to cart
    public void cartPage() {
        By cartBtn = By.xpath("//a[normalize-space()='Cart']");


    }


}
