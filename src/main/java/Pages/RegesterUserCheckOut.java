package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegesterUserCheckOut extends PageBase{
    public RegesterUserCheckOut(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input.button-1.checkout-as-guest-button")
    public WebElement guestBtn;

    @FindBy(id = "BillingNewAddress_FirstName")
    public WebElement fnTxt;

    @FindBy(id = "BillingNewAddress_LastName")
    public WebElement lnTxt;

    @FindBy(id = "BillingNewAddress_Email")
    public WebElement emailTxt;

    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement countryList;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phoneTxt;

    @FindBy(id = "BillingNewAddress_City")
    public WebElement cityTxt;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement addressTxt;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement postCodeTxt;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/button[4]")
    public WebElement continueBtn;

    @FindBy(id = "shippingoption_1")
    public WebElement shippingMethodRdo;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")
    public WebElement continueShippingBtn;
@FindBy(id = "paymentmethod_1")
public WebElement PaymentMethodRdo;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button")
    public WebElement continuePaymentBtn;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[2]/button")
    public WebElement continueInfoBtn;
@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")
public WebElement finishBuy;
    @FindBy(css = "a.product-name")
    public WebElement prodcutName;

    @FindBy(css = "input.button-1.confirm-order-next-step-button")
    public WebElement confirmBtn;

    @FindBy(css = "h1")
    public WebElement ThankYoulbl;

    @FindBy(css = "div.title")
    public WebElement successMessage;

    @FindBy(linkText = "Click here for order details.")
    public WebElement orderDetailsLink;
    @FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
public  WebElement checkasGuest;

    public void RegisteredUserCheckoutProduct(String countryName, String address, String postcode,
                                              String phone, String city, String productName)
            throws InterruptedException {
        selectObj = new Select(countryList);
        selectObj.selectByVisibleText(countryName);
        setTextElementText(cityTxt, city);
        setTextElementText(addressTxt, address);
        setTextElementText(postCodeTxt, postcode);
        setTextElementText(phoneTxt, phone);

        clickButton(continueBtn);
        clickButton(shippingMethodRdo);
        clickButton(continueShippingBtn);
        clickButton(PaymentMethodRdo);
        Thread.sleep(1000);
        clickButton(continuePaymentBtn);
        Thread.sleep(1000);
        clickButton(continueInfoBtn);
        Thread.sleep(1000);
        clickButton(finishBuy);
    }

    public void confirmOrder() throws InterruptedException
    {        Thread.sleep(2000);
        clickButton(confirmBtn);
    }

    public void viewOrderDetails() {
        clickButton(orderDetailsLink);
    }


    public void CheckoutProduct(String firstName, String lastName, String countryName,
                                String email, String address, String postcode,
                                String phone, String city, String productName)
            throws InterruptedException {
        setTextElementText(fnTxt, firstName);
        Thread.sleep(5000);
        setTextElementText(lnTxt, lastName);
        Thread.sleep(5000);
        setTextElementText(emailTxt, email);
        Thread.sleep(5000);
        selectObj = new Select(countryList);
        Thread.sleep(5000);
        selectObj.selectByVisibleText(countryName);
        Thread.sleep(5000);
        setTextElementText(cityTxt, city);
        Thread.sleep(5000);
        setTextElementText(addressTxt, address);
        Thread.sleep(5000);
        setTextElementText(postCodeTxt, postcode);
        Thread.sleep(5000);
        setTextElementText(phoneTxt, phone);
        Thread.sleep(5000);
        clickButton(continueBtn);
        Thread.sleep(5000);
        clickButton(shippingMethodRdo);
        clickButton(continueShippingBtn);
        Thread.sleep(5000);
        clickButton(continuePaymentBtn);
        Thread.sleep(5000);
        clickButton(continueInfoBtn);
        clickButton(finishBuy);
    }
public void UserCanCheckAsGuest(){
        clickButton(checkasGuest);
}


}
