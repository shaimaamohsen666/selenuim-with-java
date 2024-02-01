package Tests;

import Pages.HomePage;
import Pages.ProductDetailsSubFromProductPage;
import Pages.SearchProduct;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrency extends TestBase{
    String ProductName ="Apple MacBook Pro 13-inch";
    SearchProduct SearchObject;
    HomePage homePage;
    ProductDetailsSubFromProductPage DetailsObject;
    @Test (priority = 1)
    public void  UserCanChangeCurrency(){
        homePage = new HomePage(driver);
        homePage.ChangeCurrency();

    }
    @Test (priority = 2)
    public void UserCanSearchByAutoSuggest() throws InterruptedException {
        SearchObject = new SearchProduct(driver);
        SearchObject.ProductSearchUsingAutoSuggest("MacB");
        DetailsObject = new ProductDetailsSubFromProductPage(driver);
        Assert.assertEquals(DetailsObject.ProductNameBreadCrumb.
                getText(),(ProductName));
        Assert.assertTrue(DetailsObject.PriceChanged.getText().contains("€"));

    }


}
