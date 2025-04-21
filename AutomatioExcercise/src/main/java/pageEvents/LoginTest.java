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
    //buy new female dress
    @Test
    public void login(){
        login.login("euphemiauc94@gmail.com", "euphemia94");
        String pageTitle = login.getPageTitle();
        Assert.assertFalse(pageTitle.contains("AutomationExercise"));
    }
}
