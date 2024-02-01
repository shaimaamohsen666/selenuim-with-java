package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchProduct extends PageBase {
    public SearchProduct(WebDriver driver) {
        super(driver);
    }

          @FindBy(id = "small-searchterms")
          WebElement SearchTextBox;
       @FindBy(xpath = "//*[@id=\"small-search-box-form\"]/button")
    WebElement SearchButtonClick;
       @FindBy(linkText = "Apple MacBook Pro 13-inch")
       WebElement ProductTitle;

       @FindBy(id = "ui-id-1")
   List<WebElement>  ProductDropDownList;

public void ProductSearch(String ProductName){
    setTextElementText(SearchTextBox ,ProductName);
    clickButton(SearchButtonClick);
}

public void OpenDetailProduct(){
    clickButton(ProductTitle);
}

public void ProductSearchUsingAutoSuggest(String SearchTxt) throws InterruptedException {
    setTextElementText(SearchTextBox,SearchTxt);
    Thread.sleep(3000);
    ProductDropDownList.get(0).click();
}



















}