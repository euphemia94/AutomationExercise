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

    @Test(priority = 1)
    // New user signup; with valid credentials
    public void testUserSignup() throws InterruptedException {
        signupPage.setUpUser("Euphemia", signupPage.generateRandomEmail(), "123456");
        signupPage.selectDate();
        signupPage.addressInfo("Euphemia", "Nnaemeka", "Tech Company", "123 Main St", "Lagos", "Ikeja", "100001", "08012345678");
        signupPage.pageTitle();
        //Assert.assertTrue(actualTitle.contains("Automation Exercise - ACCOUNT CREATED!"));
    }
    @Test(priority = 2)
    // New user with invalid or missing name field
    public void SignupWithMissingName() throws InterruptedException {
        signupPage.setUpUser("", signupPage.generateRandomEmail(), "455788");
        signupPage.selectDate();
        signupPage.addressInfo("", "Nnaemeka", "--", "123 Main St", "Lagos", "Ikeja", "100001", "08012345678");        // Get the page title
        String actualTitle = signupPage.pageTitle();
        Assert.assertFalse(actualTitle.contains("Please fill out this field"));
    }
    @Test(priority = 3)
    // New user without email address
    public void emptyEmailField() throws InterruptedException {
        signupPage.setUpUser("john", "", "123456");
        signupPage.selectDate();
        signupPage.addressInfo("john", "Nnaemeka", "Jazdon Enterprise", "123 Main St", "Lagos", "Ikeja", "100001", "08012345678");        // Get the page title
        String actualTitle = signupPage.pageTitle();
        Assert.assertFalse(actualTitle.contains("ACCOUNT CREATED!"));
    }
    @Test(priority = 4)
    // New user without password
    public void withOutPassword() throws InterruptedException {
        signupPage.setUpUser("Blessing", "", "");
        signupPage.selectDate();
        signupPage.addressInfo("john", "Nnaemeka", "Jazdon Enterprise", "23 Main St", "Lagos", "Ikeja", "100001", "08012345678");        // Get the page title
        String actualTitle = signupPage.pageTitle();
        Assert.assertFalse(actualTitle.contains("ACCOUNT CREATED!"));
    }
    @Test(priority = 5)
    // New user without selecting month and day address
    public void withoutSelectingMonthAndDate() throws InterruptedException {
        signupPage.setUpUser("Beatrice", signupPage.generateRandomEmail(), "123456");
        signupPage.addressInfo("Beatrice", "Nnaemeka", "Inno Tech limited", "", "Lagos", "Ikeja", "100001", "08012345678");        // Get the page title
        String actualTitle = signupPage.pageTitle();
        Assert.assertFalse(actualTitle.contains("ACCOUNT CREATED!"));
    }

    @Test(priority = 6)
    // New user without phone number
    public void withOutAddress() throws InterruptedException {
        signupPage.setUpUser("john", signupPage.generateRandomEmail(), "123456");
        signupPage.selectDate();
        signupPage.addressInfo("", "Nnaemeka", "Inno ltd", "23, Gbada", "Lagos", "Ikeja", "100001", "08012345678");        // Get the page title
        String actualTitle = signupPage.pageTitle();
        // Assertion: Check if the title contains "ACCOUNT CREATED!" (It should fail for invalid credentials)
        Assert.assertFalse(actualTitle.contains("ACCOUNT CREATED!"));
    }
}
