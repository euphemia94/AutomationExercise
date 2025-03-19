package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    //constructor
    ProductPage(WebDriver driver)
    {
        this.driver=driver;
    }
    //locators
    //go to product and purchase top
    By goToproductPage = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]");
    By productPageBtn = By.xpath("//body/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]/a[1]");
    By p = By.xpath("//body/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]");
    //view the top of choice and purchase
    By selectTopBn = By.xpath("//body/section[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[1]/a[1]");
    ///By ("//body/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]/button[1]")).click();


}
