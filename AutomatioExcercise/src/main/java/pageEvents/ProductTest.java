package pageEvents;

import baseTest.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.ProductPage;
import pageObject.Login;

public class ProductTest extends BaseTest {
    private ProductPage productPage;
    private Login login;

    @BeforeMethod
    public void setProductTest() {
        login = new Login(driver);
        productPage = new ProductPage(driver);

    //buy new female dress
    }
    @Test
    public void buyFemaleDress() throws InterruptedException {
        login.login("euphemiauc94@gmail,com", "euphemia94");
        productPage.productPage();
    }
}
