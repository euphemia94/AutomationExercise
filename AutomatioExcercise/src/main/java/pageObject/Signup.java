package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Signup {
    WebDriver driver;
    //constructor
    Signup(WebDriver driver)
        {
            this.driver=driver;
        }
    //locators
    By SignUpbtn = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
    By nameField = By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]");
    By emailfield= By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]");
    By signUp = By.xpath("//button[contains(text(),'Signup')]");
    By gender = By.xpath("//input[@id='id_gender2']");
    By passwordField = By.xpath("//input[@id='password']");
    WebElement days = (WebElement) By.xpath("//select[@id='days']");
    WebElement month = (WebElement) By.xpath("//select[@id='months']");
    WebElement year = (WebElement) By.xpath("//select[@id='years']");
    By checkBox1 = By.xpath("//input[@id='newsletter']");
    By checkBox2 = By.xpath("//input[@id='optin']");

    By firsNameField = By.xpath("//input[@id='first_name']");
    By lastNameField = By.xpath("//input[@id='last_name']");
    By companyField = By.xpath("//input[@id='company']");
    By addressField = By.xpath("//input[@id='address1']");
    WebElement country = (WebElement) By.xpath("//select[@id='days']");
    By stateField = By.xpath("//input[@id='state']");
    By ciyField = By.xpath("//input[@id='city']");
    By zipCodeField = By.xpath(" //input[@id='zipcode']");
    By mobileNumber = By.xpath(" //input[@id='mobile_number']");
    By createAccBtn = By.xpath("//button[contains(text(),'Create Account')]");

    //sign up (//Action method)
    public void setUpUser(String name, String email, String password) throws InterruptedException {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailfield).sendKeys(email);
        driver.findElement(signUp).click();
        Thread.sleep(3000);
        driver.findElement(gender).click();
        driver.findElement(passwordField).sendKeys(password);

        //select day, month and year
        driver.findElement((By) days).click();
        Select select = new Select(days);
        select.selectByIndex(22);
        Thread.sleep(3000);
        driver.findElement((By) month).click();
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(2);
        Thread.sleep(3000);
        driver.findElement((By) year).click();
        month.click();
        Select selectYear = new Select(year);
        selectYear.selectByValue("1994");
        driver.findElement(checkBox1).click();
        driver.findElement(checkBox2).click();
    }
    public void addressInfo(String firstName, String lastName, String company, String address,
                            String state, String city, String zipCode, String number){
        driver.findElement(firsNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement((By) country).click();
        Select select1 = new Select(country);
        select1.selectByIndex(2);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(ciyField).sendKeys(city);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(mobileNumber).sendKeys(number);
        driver.findElement(createAccBtn).click();
        String pageTitle = driver.getTitle();
    }

    //signup
}
