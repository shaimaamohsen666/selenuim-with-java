package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{
    public EmailPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FriendEmail")
    WebElement FriendMail;
    @FindBy(id = "PersonalMessage")
    WebElement PersonalMessage;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
    WebElement SubmitBtn;
    @FindBy(css = "div.result")
 public   WebElement MessageNotification;
public void SendEmail(String Mail , String personalMsg){
    setTextElementText(FriendMail,Mail);
    setTextElementText(PersonalMessage,personalMsg);
    clickButton(SubmitBtn);
}


}
