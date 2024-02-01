package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (linkText = "Change password")
    WebElement changePasswordInList;
    @FindBy(id="OldPassword")
    WebElement OldPasswordTxt;
    @FindBy(id = "NewPassword")
    WebElement NewPasswordTxt;
    @FindBy(id="ConfirmNewPassword")
    WebElement ConfirmNewPasswordTxt;

    @FindBy(linkText = "Change password")
    WebElement ChangepasswordBtn;

    public void openChangePasswordInList(){
        clickButton(changePasswordInList);
    }
    public void ChangeOldPassword(String OldPasswordFunction ,String NewPasswordFunction ,
                                  String ConfirmNewPasswordFunction)
    {
        setTextElementText(OldPasswordTxt,OldPasswordFunction);
        setTextElementText(NewPasswordTxt,ConfirmNewPasswordFunction);
        setTextElementText(ConfirmNewPasswordTxt,ConfirmNewPasswordFunction);
        clickButton(ChangepasswordBtn);
    }
}
