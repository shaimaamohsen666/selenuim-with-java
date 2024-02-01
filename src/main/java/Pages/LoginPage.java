package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Email")
    WebElement EmailTxt;
    @FindBy(id="Password")
    WebElement PasswordTxt;
    @FindBy(xpath ="/html/body/div[6]/div[3]/div/div/" +
            "div/div[2]/div[1]/div[2]/form/div[3]/button")
    WebElement LoginBtn;
    public void UserLogin(String EmailLogin , String PasswordLogin){
        setTextElementText(EmailTxt,EmailLogin);
        setTextElementText(PasswordTxt,PasswordLogin);
        clickButton(LoginBtn);
    }
}
