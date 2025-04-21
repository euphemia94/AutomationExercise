package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;
    //WebDriver driver;
    //constructor
    public Login (WebDriver driver)
    {
        this.driver=driver;
    }
    public void login(String email, String password){
        // locators
        By loginBtn = By.xpath("//a[normalize-space()='Signup / Login']");
        By emailField = By.xpath("//input[@data-qa='login-email']");
        By passwordField = By.xpath("//input[@placeholder='Password']");
        By loginBtn2 = By.xpath("//button[normalize-space()='Login']");
        driver.findElement(loginBtn).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn2).click();
    }
    // Get the actual browser title
    public String getPageTitle() {
        return driver.getTitle(); // Corrected: Now it returns the actual title.

    }
    public void subscriptionMessage (){
        By subscriptionImputeField = By.xpath("//input[@id='susbscribe_email']");
        By subscribeBtn = By.xpath("//input[@id='susbscribe_email']");
    //You have b
    }
}
