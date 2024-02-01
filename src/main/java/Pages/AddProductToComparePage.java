package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddProductToComparePage extends PageBase{
    public AddProductToComparePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a.clear-list")
    private WebElement clearListLink;

    @FindBy(css = "div.no-data")
    public WebElement noDataLbl;

    @FindBy(css = "table.compare-products-table")
    private WebElement compareTable;

    @FindBy(tagName = "tr")
    public List<WebElement> allRows;

    @FindBy(tagName = "td")
    public List<WebElement> allCol;

    @FindBy(linkText="Asus N551JK-XO076H Laptop")
    public WebElement firstProductName;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a")
    public WebElement firstProductNamee;

    @FindBy(linkText="Apple MacBook Pro 13-inch")
    public WebElement secondProductName ;
@FindBy (xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[3]/a")
public WebElement secondProductNamee ;

    public void clearCompareList()
    {
        clickButton(clearListLink);
    }

    public void CompareProducts()
    {
        // Get all Rows
        System.out.println(allRows.size());
        // Get data from each Row
        for(WebElement row : allRows)
        {
            System.out.println(row.getText() + "\t");
            for(WebElement col : allCol)
            {
                System.out.println(col.getText()+"\t");
            }
        }
    }

}








