package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegestrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserRegistrationTest extends TestBase{

HomePage homeObject;
UserRegestrationPage registerObject;//2
    LoginPage loginObject;
   @Test(priority = 1,alwaysRun = true)
    public void UserCanRegisterSuccssfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegestrationPage(driver);//2
        //الفانكشن اللى هنملى فيها الحاجة
        registerObject.userRegistration("shaimaa", "mohsen", "shaimaa99999900@yahoo.com", "123456789090");
      Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }
    @Test(dependsOnMethods ={"UserCanRegisterSuccssfully" })

    public void UserCanLogin(){
       homeObject.OpenLoginPage();
       loginObject =new LoginPage(driver);
loginObject.UserLogin("shaimaa99999900@yahoo.com","123456789090");

    }
}
