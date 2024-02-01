package Tests;

import Pages.AddProductToComparePage;
import Pages.ProductDetailsSubFromProductPage;
import Pages.SearchProduct;
import Pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCompare extends TestBase {
    String firstProductName = "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop";

    SearchProduct searchPage;
AddProductToComparePage CompObj;
    ProductDetailsSubFromProductPage productDetails;

    @Test(priority = 1)
    public void UserCanCompareProducts() throws InterruptedException {
        searchPage = new SearchProduct(driver);
        productDetails = new ProductDetailsSubFromProductPage(driver);
        CompObj = new AddProductToComparePage(driver);

        searchPage.ProductSearchUsingAutoSuggest("Asus");
        Assert.assertTrue(productDetails.ProductNameBreadCrumb.getText().contains(secondProductName));
        productDetails.AddProductToCompare();
        Thread.sleep(1000);
        searchPage.ProductSearchUsingAutoSuggest("MacB");
        Assert.assertTrue(productDetails.ProductNameBreadCrumb.getText().contains(firstProductName));
        productDetails.AddProductToCompare();




        driver.navigate().to("http://demo.nopcommerce.com" + "/compareproducts");
       Assert.assertTrue(CompObj.firstProductNamee.getText().equals("Asus N551JK-XO076H Laptop"));
        Thread.sleep(3000);
        Assert.assertTrue(CompObj.secondProductNamee.getText().equals("Apple MacBook Pro 13-inch"));
        Thread.sleep(5000);
        CompObj.CompareProducts();
        Thread.sleep(3000);
    }

    @Test(priority=2)
    public void UserCanClearCompareList() {
        CompObj.clearCompareList();
        Assert.assertTrue(CompObj.noDataLbl.getText().contains("You have no items to compare."));
    }
}



















