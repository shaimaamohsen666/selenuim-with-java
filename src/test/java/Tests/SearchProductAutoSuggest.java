package Tests;

import Pages.ProductDetailsSubFromProductPage;
import Pages.SearchProduct;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductAutoSuggest extends TestBase{
    String ProductName ="Apple MacBook Pro 13-inch"; //any name from site
    SearchProduct SearchObject;
    ProductDetailsSubFromProductPage DetailsObject;
    @Test
    public void UserCanSearchByAutoSuggest() throws InterruptedException {
        SearchObject = new SearchProduct(driver);
        SearchObject.ProductSearchUsingAutoSuggest("MacB");
        DetailsObject = new ProductDetailsSubFromProductPage(driver);
        Assert.assertEquals(DetailsObject.ProductNameBreadCrumb.
                              getText(),(ProductName));

    }

}
