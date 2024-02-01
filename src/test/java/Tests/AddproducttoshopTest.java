package Tests;

import Pages.AddProductToShopping;
import Pages.ProductDetailsSubFromProductPage;
import Pages.SearchProduct;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddproducttoshopTest extends TestBase{

    SearchProduct searchPage;
    ProductDetailsSubFromProductPage productDetails;
    AddProductToShopping cartPage ;
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority=1)
    public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
        searchPage = new SearchProduct(driver);
        searchPage.ProductSearchUsingAutoSuggest("MacB");
        productDetails = new ProductDetailsSubFromProductPage(driver);
        Assert.assertTrue(productDetails.ProductNameBreadCrumb.getText().contains(productName));
    }

    @Test(priority=2)
    public void UserCanAddProductToShoppingCart() throws InterruptedException {
        productDetails = new ProductDetailsSubFromProductPage(driver);
        productDetails.AddToCart();
        Thread.sleep(4000);
        driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
        cartPage = new AddProductToShopping(driver);
        Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));
    }

    @Test(priority=3)
    public void UserCanRemoveProductFromCart() {
        cartPage = new AddProductToShopping(driver);
        cartPage.RemoveProductFromCart();
        Assert.assertTrue(cartPage.MessageInCard.getText().contains("Your Shopping Cart is empty!"));
    }
   /* public void UserCanAddQuantity(){
        cartPage= new AddProductToShopping(driver);
        cartPage.UpdateProductQuantityInCart("4");

    }*/
}




