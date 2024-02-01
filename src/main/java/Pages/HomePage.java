package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }
    @FindBy(linkText="Register")
    WebElement registerLink ;

@FindBy(linkText = "Contact us")
WebElement ContactUsInterface;
  @FindBy(linkText ="Log in")
  WebElement LoginLink;
    @FindBy(linkText="My account")
    WebElement MyAccountBtn;
    @FindBy (id = "customerCurrency")
    public WebElement CurrencyDDL;
    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a ") //hovermenue
    WebElement ComputerMenu;
    @FindBy(xpath ="/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
    WebElement NotebooksMenu;
@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1")
public WebElement Message;
    public void openRegistrationPage()
    {
        registerLink.click();
    }
    public void OpenLoginPage()
    {
        LoginLink.click();
    }
    public void OpenMyAccount()
    {
        MyAccountBtn.click();
    }

    public void OpenContactUsPage(){
        ScrollToBottom();
        clickButton(ContactUsInterface);

    }
    public void ChangeCurrency(){
        selectObj = new Select(CurrencyDDL);//
        selectObj.selectByVisibleText("Euro");
    }
    public void  OpenHoverMenu(){
     action.moveToElement(ComputerMenu).moveToElement(NotebooksMenu).click().build().perform();
}}
