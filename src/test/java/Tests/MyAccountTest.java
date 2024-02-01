package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegestrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase{
    HomePage homeObject;
    UserRegestrationPage registerObject;
    LoginPage loginObject;
    MyAccountPage myAccountObject;
    @Test(priority = 1)
    public void UserCanRegisterSuccssfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegestrationPage(driver);//2

        registerObject.userRegistration("shaimaa", "mohsen",
                "shaimaa66666666@yahoo.com", "66666666");
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
}
    @Test(priority = 2)

    public void UserCanLogin(){
        homeObject.OpenLoginPage();
        loginObject =new LoginPage(driver);
        loginObject.UserLogin("shaimaa66666666@yahoo.com","66666666");

    }
@Test(priority = 3)
public void UserCanChangePassword() {
        homeObject.OpenMyAccount();
    myAccountObject = new MyAccountPage(driver);
    myAccountObject.openChangePasswordInList();
    myAccountObject.ChangeOldPassword("66666666",
            "8888888888",
            "8888888888");
}}