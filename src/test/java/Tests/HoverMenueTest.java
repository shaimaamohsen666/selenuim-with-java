package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverMenueTest extends TestBase{
    HomePage homeObj;
    @Test
    public void UserCanOpenHoverMenu(){
        homeObj = new HomePage(driver);
        homeObj.OpenHoverMenu();
     //   Assert.assertTrue(homeObj.Message.getText().contains("Notebooks"));
Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }





}
