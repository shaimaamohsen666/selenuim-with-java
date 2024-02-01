package Tests;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUs extends TestBase{
    HomePage homeObject;//1 عشان انا بعمل كليك ع الهوم
    ContactUsPage ContactObject;
    String Email = "shaimaamohsen666@yhpp.com";
    String UserName = "Shm2m2";
    String Quiry = "this site is very slowly";
    @Test
    public void UserCanContactUs()   {

        homeObject =new HomePage(driver);
        homeObject.OpenContactUsPage();
        ContactObject = new ContactUsPage(driver);
        ContactObject.Contactus(UserName,Email,Quiry);
        Assert.assertTrue(ContactObject.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
        System.out.println(ContactObject.successMessage.getText());

    }


}
