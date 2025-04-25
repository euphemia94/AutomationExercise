package pageEvents;


import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.Login;
import pageObject.ProductPage;

public class LoginTest extends BaseTest {
    Login login;
    @BeforeMethod
    public void setLoginTest() {
        login = new Login(driver);
    }
    //valid user login
    @Test(priority = 1)
    public void login(){
        login.login("euphemiauc94@gmail.com", "Euphemia94");
        String pageTitle = login.getPageTitle();
        Assert.assertTrue(pageTitle.contains("Automation Exercise"));
    }
    //login with invalid or missing email field
    @Test(priority = 2)
    public void loginWithInvalidDetails(){
        login.login("euphemiaucgmail", "euphemia94");
        String validationMsg = login.getEmailValidationMessage();
        System.out.println("Validation message: " + validationMsg);
        Assert.assertTrue(validationMsg.contains("@")); // or use the full expected text
    }
    //login with empty or invalid password
    @Test(priority = 3)
    public void loginWrongPassword(){
        login.login("euphemiauc94@gmail.com", "");
        String validationMsg = login.getEmailValidationMessage();
        System.out.println("Validation message: " + validationMsg);
        Assert.assertTrue(validationMsg.contains("Please fill out this field"));
    }
    //login with empty email and password
    @Test(priority = 4)
    public void loginWithEmptyField(){
        login.login("", "");
        String pageTitle = login.getPageTitle();
        Assert.assertFalse(pageTitle.contains("Automation Exercise"));
    }
    //subscribe to newletter
    @Test(priority = 5)
    public void subscribe() throws InterruptedException {
        String successMessage = login.subscriptionMessage();
        System.out.println("Subscription Message: " + successMessage);
        wait(2000);
        Assert.assertTrue(successMessage.contains("You have been successfully subscribed!"));
    }
    //subscription without email
    @Test(priority = 6)
    public void subscribeWithout() throws InterruptedException {
        String successMessage = login.subscriptionMessage();
        System.out.println("Subscription Message: " + successMessage);
        wait(2000);
        Assert.assertFalse(successMessage.contains("You have been successfully subscribed!"));
    }
}
