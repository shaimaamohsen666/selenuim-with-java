package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegestrationToCheckOutTest extends TestBase {


        // Register User
// Search for product
	//Add to Cart
	// Checkout
	//Logout

    HomePage homeObject ;
    UserRegestrationPage registerObject ;
    LoginPage loginObject ;
    String productName = "Apple MacBook Pro 13-inch";
    SearchProduct searchObject ;
    ProductDetailsSubFromProductPage detailsObject ;
    AddProductToShopping cartPage ;
    RegesterUserCheckOut checkoutObject ;
    OrderDetailsPage orderObject;
    LoginPage logObj;
    AddProductToShopping shoppingObj;

    @Test(priority=1,alwaysRun=true)
    public void UserCanRegisterSuccssfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegestrationPage(driver);
        registerObject.userRegistration("shaimaa", "mohsen", "shosho0oo@gmail.com", "1234567899");
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }

    @Test(priority=2)
    public void UserCanSearchWithAutoSuggest()
    {
        try {
            searchObject = new SearchProduct(driver);
            searchObject.ProductSearchUsingAutoSuggest("MacB");
            detailsObject = new ProductDetailsSubFromProductPage(driver);
            Assert.assertEquals(detailsObject.ProductNameBreadCrumb.getText(), productName);
        } catch (Exception e) {
            System.out.println("Error occurred  " + e.getMessage());
        }
    }

    @Test(priority=3)
    public void UserCanAddProductToShoppingCart() throws InterruptedException {
        detailsObject = new ProductDetailsSubFromProductPage(driver);
        detailsObject.AddToCart();
        Thread.sleep(1000);
        driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
        cartPage = new AddProductToShopping(driver);
        Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));
    }

    @Test(priority=4)
    public void UserCanCheckoutProduct() throws InterruptedException {
        checkoutObject = new RegesterUserCheckOut(driver);
        cartPage.openCheckoutPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin("shosho0oo@gmail.com", "1234567899");
shoppingObj = new AddProductToShopping(driver);
shoppingObj.openCheckoutPage();
        checkoutObject.RegisteredUserCheckoutProduct
                ("Egypt", "test address", "123456", "32445566677", "Cairo", productName);
        Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
        Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
        checkoutObject.confirmOrder();
        Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
        checkoutObject.viewOrderDetails();
        Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
        orderObject = new OrderDetailsPage(driver);
        orderObject.DownloadPDFInvoice();
        orderObject.PrintOrderDetails();

    }


}


