package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriend extends TestBase{
    String ProductName ="Apple MacBook Pro 13-inch"; //any name from site

    HomePage homeObject;
    UserRegestrationPage registerObject;//2
    LoginPage loginObject;
    SearchProduct SearchObject;
    ProductDetailsSubFromProductPage DetailsObject;
    EmailPage EmailObject;
    @Test(priority = 1,alwaysRun = true)
    // نعمل تسجيل الاول
    public void UserCanRegisterSuccssfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegestrationPage(driver);
        registerObject.userRegistration("shaimaaaa", "mohsen", "shaimaa1111@yahoo.com", "1234566");
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }

    @Test(priority = 2 )

    public void UserCanLogin(){homeObject.OpenLoginPage();

        loginObject =new LoginPage(driver);
        loginObject.UserLogin("shaimaa1111@yahoo.com","1234566");

    }

    @Test(priority = 3)
    public void UserCanSearchByAutoSuggest() throws InterruptedException {
        SearchObject = new SearchProduct(driver);
        SearchObject.ProductSearchUsingAutoSuggest("MacB");
        DetailsObject = new ProductDetailsSubFromProductPage(driver);
        Assert.assertEquals(DetailsObject.ProductNameBreadCrumb.
                getText(),(ProductName));
    }
    @Test (priority = 4)
    public void RgesteredUserCanSendEmail(){
        DetailsObject.openSendTofriendBtn();
        EmailObject = new EmailPage(driver);
        EmailObject.SendEmail("Ronyrony@gmail.com","this product for you");
        Assert.assertTrue(EmailObject.MessageNotification.getText().contains("Your message has been sent."));
        System.out.println(EmailObject.MessageNotification.getText());

    }

}























