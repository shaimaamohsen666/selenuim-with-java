package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReviewOnProdct extends TestBase{
HomePage homeObject;
UserRegestrationPage registerObject;
LoginPage loginObject;
    String ProductName ="Apple MacBook Pro 13-inch"; //any name from site
    SearchProduct SearchObject;
    ProductDetailsSubFromProductPage DetailsObject;
AddReviewPage AddReviewObject;


    @Test(priority = 1,alwaysRun = true)
    // نعمل تسجيل الاول
    public void UserCanRegisterSuccssfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegestrationPage(driver);
        registerObject.userRegistration("shaimaaaa", "mohsen", "shaimaa1111101@yahoo.com", "1234567890001");
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }

    @Test(priority = 2 )

    public void UserCanLogin(){
        homeObject.OpenLoginPage();
        loginObject =new LoginPage(driver);
        loginObject.UserLogin("shaimaa1111101@yahoo.com","1234567890001");

    }

    @Test (priority = 3)
    public void UserCanSearchByAutoSuggest() throws InterruptedException {
        SearchObject = new SearchProduct(driver);
        SearchObject.ProductSearchUsingAutoSuggest("MacB");
        DetailsObject = new ProductDetailsSubFromProductPage(driver);
        Assert.assertEquals(DetailsObject.ProductNameBreadCrumb.
                getText(),(ProductName));}

    @Test(priority = 4)
    public  void UserCanReviewProduct() throws InterruptedException {
        DetailsObject =new ProductDetailsSubFromProductPage(driver);
DetailsObject.ClickReview();
AddReviewObject = new AddReviewPage(driver);
Thread.sleep(4000);
AddReviewObject.OpenReviewPage("this is my review" , "product is usfel");
Assert.assertTrue(AddReviewObject.MessageDisplayed.getText().contains("Product review is successfully added."));
System.out.println(AddReviewObject.MessageDisplayed.getText());}}