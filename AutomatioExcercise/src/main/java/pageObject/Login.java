package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public String getPasswordValidationMessage() {
        WebElement passWordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        return passWordField.getAttribute("validationMessage");
    }
    public String subscriptionMessage(String email) {
        By subscriptionInputField = By.xpath("//input[@id='susbscribe_email']");
        By subscribeBtn = By.xpath("//button[@id='subscribe']");
        By successMsg = By.xpath("//div[@class='alert-success']"); // Adjust if actual message d// iffers

        driver.findElement(subscriptionInputField).sendKeys(email);
        driver.findElement(subscribeBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(successMsg));

        return driver.findElement(successMsg).getText(); //  "You have been successfully subscribed!"
    }
}
