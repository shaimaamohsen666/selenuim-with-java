package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToShopping extends PageBase {
    public AddProductToShopping(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr/td[7]")
    WebElement removeCheck;

    @FindBy(name = "updatecart")
    WebElement updateCartBtn;

    @FindBy(css = "input.qty-input valid")
    public WebElement quantityTxt;//Total
@FindBy(id = "itemquantity11234")
public WebElement quantityTxtt;
    @FindBy(css = "td.subtotal")
    public WebElement totalLbl;
    @FindBy(id="checkout")
    WebElement checkoutBtn ;

    @FindBy(id="termsofservice")
    WebElement agreeCheckbox;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div")
   public WebElement MessageInCard;


    public void RemoveProductFromCart() {
        clickButton(updateCartBtn);
        clickButton(removeCheck);

    }

    public void UpdateProductQuantityInCart(String quantity) {
        //clear quantity textbox
        clearText(quantityTxtt);//
        setTextElementText(quantityTxtt, quantity);
        clickButton(updateCartBtn);
    }
    public void openCheckoutPage()
    {
        clickButton(agreeCheckbox);
        clickButton(checkoutBtn);
    }


}
