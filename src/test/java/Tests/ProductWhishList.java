package Tests;

import Pages.ProductDetailsSubFromProductPage;
import Pages.SearchProduct;
import Pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductWhishList extends TestBase{

    SearchProduct searchPage;
    ProductDetailsSubFromProductPage productDetails;
    WishListPage wishlistObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority=1)
    public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
        searchPage = new SearchProduct(driver);
        searchPage.ProductSearchUsingAutoSuggest("MacB");
        productDetails = new ProductDetailsSubFromProductPage(driver);
        Assert.assertTrue(productDetails.ProductNameBreadCrumb.getText().contains(productName));
    }
    @Test(priority=2)
    public void UserCanAddProductToWishlist() throws InterruptedException {
        productDetails = new ProductDetailsSubFromProductPage(driver);
        productDetails.AddProductToWishList();
        driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");
        wishlistObject = new WishListPage(driver);
        Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
        Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
    }
    @Test(priority=3)
    public void UserCanRemoveProductFromCart() {
        wishlistObject = new WishListPage(driver);
        wishlistObject.removeProductFromWishlist();
     System.out.println(wishlistObject.EmptyCartLbl.getText());
       // Assert.assertTrue(wishlistObject.EmptyCartLbl.getText().contains("The wishlist is empty!"));
    }







}
