package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")
    WebElement LinkDetails;
    @FindBy(css = "a.button-2.pdf-invoice-button")
    public WebElement pdfInvoiceLink;

    @FindBy(css = "a.button-2.print-order-button")
    public WebElement printInvoiceLnk;

    public void PrintOrderDetails() {
        clickButton(printInvoiceLnk);
    }

    public void DownloadPDFInvoice() throws InterruptedException {
        clickButton(pdfInvoiceLink);
        Thread.sleep(2000);
    }
}
