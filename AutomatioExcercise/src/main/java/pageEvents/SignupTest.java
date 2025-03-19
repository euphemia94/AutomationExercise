package pageEvents;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.Signup;

public class SignupTest extends BaseTest {

    private Signup signupPage;

    @BeforeMethod
    public void setUpTest() {
        signupPage = new Signup(driver);
    }

    @Test
    // New user signup with valid credentials
    public void testUserSignup() throws InterruptedException {
        signupPage.setUpUser("Euphemia", signupPage.generateRandomEmail(), "123456");
        signupPage.selectDate();
        signupPage.addressInfo("Euphemia", "Nnaemeka", "Tech Company", "123 Main St", "Lagos", "Ikeja", "100001", "08012345678");
        // Get the page title
        signupPage.pageTitle();
        //Assert.assertTrue(actualTitle.contains("Automation Exercise - ACCOUNT CREATED!"));
    }

    @Test
    // New user with invalid credentials
    public void SignupWithInvalidDetails() throws InterruptedException {
        signupPage.setUpUser("0000000", signupPage.generateRandomEmail(), "123456");
        signupPage.selectDate();
        signupPage.addressInfo("", "Nnaemeka", "--", "123 Main St", "Lagos", "Ikeja", "100001", "08012345678");        // Get the page title
        String actualTitle = signupPage.pageTitle();
        // Assertion: Check if the title contains "ACCOUNT CREATED!" (It should fail for invalid credentials)
        Assert.assertFalse(actualTitle.contains("ACCOUNT CREATED!"));
    }
}
