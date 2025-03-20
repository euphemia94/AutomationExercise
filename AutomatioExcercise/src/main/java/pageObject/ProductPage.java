package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;
    //constructor
    public ProductPage(WebDriver driver) {
        this.driver=driver;
    }
    //go to product and purchase top
    public void productPage() throws InterruptedException {
        //locators
        By productBtn = By.xpath("//a[@href='/products']");
        By selectCategory = By.xpath("//a[normalize-space()='Women']");
        By selectClothTyp = By.xpath("//a[normalize-space()='Tops']");
        By blackDress = By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]");
        By selQuantity = By.xpath("//input[@id='quantity']");
        By addDressToCard= By.xpath("//button[@type='button']");
        By contineShoping = By.xpath("//button[@class='btn btn-success close-modal btn-block']");

        driver.findElement(productBtn).click();
        driver.findElement(selectCategory).click();
        driver.findElement(selectClothTyp).click();
        driver.findElement(blackDress).click();
        WebElement quantity = driver.findElement(selQuantity);

        Select selectQuantity = new Select(quantity);
        selectQuantity.selectByIndex(1);
        Thread.sleep(3000);
        driver.findElement(addDressToCard);
        driver.findElement(contineShoping);
    }

}
