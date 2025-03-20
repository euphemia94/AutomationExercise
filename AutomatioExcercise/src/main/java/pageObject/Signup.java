package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

public class Signup {
    WebDriver driver;
    //WebDriver driver;
    //constructor
    public Signup(WebDriver driver)
        {
            this.driver=driver;
        }
    // Method to generate a random email
    public String generateRandomEmail() {
        Random random = new Random();
        int randomNumber = random.nextInt(100000); // Generates a random number
        return "testuser" + randomNumber + "@example.com";
    }
    //sign up (//Action method)
    public void setUpUser(String name, String email, String password) throws InterruptedException {
        //locators
        By SignUpbtn = By.xpath("//a[normalize-space()='Signup / Login']");
        By nameField = By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]");
        By emailfield= By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]");
        By signUp = By.xpath("//button[contains(text(),'Signup')]");
        By gender = By.xpath("//input[@id='id_gender2']");
        By passwordField = By.xpath("//input[@id='password']");
        String randomEmail = generateRandomEmail();
        driver.findElement(SignUpbtn).click();
        Thread.sleep(3000);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailfield).sendKeys(randomEmail);
        driver.findElement(signUp).click();
        Thread.sleep(1000);

        driver.findElement(gender).click();
        driver.findElement(passwordField).sendKeys(password);
    }
    public String getValidationMessage() {
        WebElement nameInput = driver.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", nameInput);
    }
    //select day, month and year
    public void selectDate() throws InterruptedException {
        WebElement days = driver.findElement(By.xpath("//select[@id='days']"));
        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        By checkBox1 = By.xpath("//input[@id='newsletter']");
        By checkBox2 = By.xpath("//input[@id='optin']");
        days.click();
        //driver.findElement((By) days).click();
        Select select = new Select(days);
        select.selectByIndex(22);
        Thread.sleep(1000);

        month.click();
        //driver.findElement((By) month).click();
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(2);
        Thread.sleep(1000);

        year.click();
        //driver.findElement((By) year).click();
        month.click();
        Select selectYear = new Select(year);
        selectYear.selectByValue("1994");
        driver.findElement(checkBox1).click();
        driver.findElement(checkBox2).click();
    }
    public void addressInfo(String firstName, String lastName, String company, String address,
                            String state, String city, String zipCode, String number) throws InterruptedException {
        By firsNameField = By.xpath("//input[@id='first_name']");
        By lastNameField = By.xpath("//input[@id='last_name']");
        By companyField = By.xpath("//input[@id='company']");
        By addressField = By.xpath("//input[@id='address1']");
        Thread.sleep(2000);
        WebElement country = driver.findElement(By.xpath("//select[@id='days']"));
        By stateField = By.xpath("//input[@id='state']");
        By ciyField = By.xpath("//input[@id='city']");
        By zipCodeField = By.xpath(" //input[@id='zipcode']");
        By mobileNumber = By.xpath(" //input[@id='mobile_number']");
        By createAccBtn = By.xpath("//button[contains(text(),'Create Account')]");

        driver.findElement(firsNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(addressField).sendKeys(address);
        country.click();
        Select select1 = new Select(country);
        select1.selectByIndex(2);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(ciyField).sendKeys(city);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(mobileNumber).sendKeys(number);
        driver.findElement(createAccBtn).click();
    }
    public String pageTitle(){
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

}
