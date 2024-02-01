package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[4]")
    public WebElement productCell;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
    public WebElement wishlistHeader;

    @FindBy(xpath = "//*[@id=\"updatecart\"]")
    public WebElement updateWishlistBtn;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]")
    public WebElement deleteItem;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[1]")
    WebElement removefromCartCheck;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div")
    public WebElement EmptyCartLbl;

    public void removeProductFromWishlist() {
        clickButton(removefromCartCheck);
        clickButton(updateWishlistBtn);
        clickButton(deleteItem);

    }
}
