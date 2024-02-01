package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsSubFromProductPage extends PageBase{
    public ProductDetailsSubFromProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "strong.current-item")
    public WebElement ProductNameBreadCrumb;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[9]/div[3]/button")
     WebElement SendToFriendBtn;
    @FindBy(xpath = "//*[@id=\"price-value-4\"]")
     public WebElement PriceChanged;
    @FindBy(linkText = "Add your review")
    WebElement AddReviewBtn;
    @FindBy(id="add-to-wishlist-button-4")
    WebElement WishListBtn;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[8]/div[2]/button")
    WebElement AddTOCompareBtn;
    @FindBy(css="input.button-2.add-to-compare-list-button")
    WebElement addToCompareBtn ;
    @FindBy(linkText="Add your review")
    WebElement addReviewLink;
    @FindBy(id="add-to-cart-button-4")
    WebElement addToCartBtn ;


    public void AddToCart()
    {
        clickButton(addToCartBtn);
    }
    public void openSendTofriendBtn(){
        clickButton(SendToFriendBtn);
    }
    public void ClickReview(){
        clickButton(AddReviewBtn);
    }
    public void AddProductToWishList(){
        clickButton(WishListBtn);
    }
    public void AddProductToCompare(){
        clickButton(AddTOCompareBtn);
    }
}
