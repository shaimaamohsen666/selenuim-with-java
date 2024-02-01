package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FullName")
   private WebElement YourNameTxt;
    @FindBy(id = "Email")
    private WebElement YourEmailTxt;
    @FindBy(id = "Enquiry")
    private WebElement EnquiryTxt;
   @FindBy(name = "send-email")
   private WebElement SubmitButton;
   @FindBy(css = "div.result")
    public  WebElement successMessage;
   public  void Contactus(String Name , String Email , String Enquiry ){
       setTextElementText(YourNameTxt,Name);
       setTextElementText(YourEmailTxt,Email);
       setTextElementText(EnquiryTxt,Enquiry);
       clickButton(SubmitButton);
   }
}
