package Tests;

import Utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.reporters.jq.Main;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    //مئولة عن فتح السايت
    //method
    public void startDriver() throws InterruptedException {
       driver= new EdgeDriver();
      // driver =new FirefoxDriver();
      //  driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("http://demo.nopcommerce.com/");

        Thread.sleep(4000);
    }
    @AfterSuite
    public void closeDriver()
    {
        driver.quit();
}
  @AfterMethod
public void ScreenShootFailure(ITestResult result){
    if (result.getStatus()==ITestResult.FAILURE);
      System.out.println("failed");
      System.out.println("TakingScreenShoot");
      Helper.captureScreenshot(driver,result.getName());
    }
}
