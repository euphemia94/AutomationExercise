package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class  Login {
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
        return driver.getTitle(); // Corrected: Now it returns the actual title
    }
    public String getEmailValidationMessage() {
        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        return emailField.getAttribute("validationMessage");
    }
    public String subscriptionMessage() {
        By subscriptionInputField = By.xpath("//input[@id='susbscribe_email']");
        By subscribeBtn = By.xpath("//button[@id='subscribe']");
        By successMsg = By.xpath("//div[@class='alert-success']"); // Adjust if actual message d// iffers

        driver.findElement(subscriptionInputField).sendKeys("euphemiauc94@gmail.com");
        driver.findElement(subscribeBtn).click();
        return driver.findElement(successMsg).getText(); //  "You have been successfully subscribed!"
    }
}
