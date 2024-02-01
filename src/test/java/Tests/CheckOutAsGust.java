package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutAsGust extends TestBase{

           SearchProduct searchObject;
        HomePage homeObject;
        ProductDetailsSubFromProductPage productDetails;
        AddProductToShopping cartObject;
       RegesterUserCheckOut checkoutObject;
        OrderDetailsPage orderObject;
        LoginPage logObject;
        String productName = "Apple MacBook Pro 13-inch";

        @Test(priority=1)
        public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
            searchObject = new SearchProduct(driver);
            searchObject.ProductSearchUsingAutoSuggest("MacB");
            productDetails = new ProductDetailsSubFromProductPage(driver);
            Assert.assertTrue(productDetails.ProductNameBreadCrumb.getText().contains(productName));
        }

        @Test(priority=2)
        public void UserCanAddProductToShoppingCart() throws InterruptedException {
            cartObject = new AddProductToShopping(driver);
            productDetails.AddToCart();
            Thread.sleep(2000);
            driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
            cartObject = new AddProductToShopping(driver);
            Assert.assertTrue(cartObject.totalLbl.getText().contains("3,600"));
        }

        @Test(priority=3)
        public void UserCanCheckoutProduct() throws InterruptedException {
            checkoutObject = new RegesterUserCheckOut(driver);
                      cartObject.openCheckoutPage();
                      Thread.sleep(3000);
            checkoutObject = new RegesterUserCheckOut(driver);
            checkoutObject.UserCanCheckAsGuest();
            checkoutObject.CheckoutProduct("shaimaa", "shaimaaa", "Egypt"
                    , "shaimaa555@yahoo.com", "test address", "123456", "32445566677", "Cairo", productName);
          Thread.sleep(5000);
            Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
            Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
            checkoutObject.confirmOrder();
            Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
        }

        @Test(priority=4)
        public void UserCanViewOrderDetails() throws InterruptedException {
            orderObject = new OrderDetailsPage(driver);
            checkoutObject.viewOrderDetails();
            Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
            orderObject.DownloadPDFInvoice();
            Thread.sleep(3000);
            orderObject.PrintOrderDetails();}

    }
