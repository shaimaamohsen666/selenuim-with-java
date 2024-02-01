package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase {
    public AddReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement AddProductReviewTitleTxt;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement ReviewTextTxt;
    @FindBy(id = "addproductrating_4")
    WebElement RateBtn;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[2]/button")
    WebElement SubmitBtn;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
   public WebElement MessageDisplayed;

public void OpenReviewPage(String title , String text ){
  setTextElementText(AddProductReviewTitleTxt ,title);
  setTextElementText( ReviewTextTxt , text);
 clickButton(RateBtn);
 clickButton(SubmitBtn);

}




}