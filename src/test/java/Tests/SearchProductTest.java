package Tests;

import Pages.PageBase;
import Pages.ProductDetailsSubFromProductPage;
import Pages.SearchProduct;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{
    String ProductName ="Apple MacBook Pro 13-inch";
SearchProduct SearchObject;
ProductDetailsSubFromProductPage DetailsObject;

    @Test
public void UserCanSearchProduct(){
        SearchObject = new SearchProduct(driver);
        DetailsObject =new ProductDetailsSubFromProductPage(driver);
        SearchObject.ProductSearch(ProductName);
        SearchObject.OpenDetailProduct();
        Assert.assertTrue(DetailsObject.ProductNameBreadCrumb.
                getText().equalsIgnoreCase(ProductName));
        // Assert.assertEquals(DetailsObject.ProductNameBreadCrumb.
        //                getText(),(ProductName));
    }

















}
