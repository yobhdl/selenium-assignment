package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.TestBase;

import static actions.ActionWebElements.click;
import static actions.ActionWebElements.getText;

public class AccountPage extends TestBase {

    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ui-id-5")
    private WebElement menLink;

    @FindBy(linkText = "Jackets")
    private WebElement jacketLink;

    @FindBy(linkText = "Montana Wind Jacket")
    private WebElement montanaJacket;

    @FindBy(xpath = "//tr[contains(@id,'order-item-row-')]/td/strong")
    private WebElement productItemName;

    @FindBy(xpath = "//tr[contains(@id,'order-item-row-')]//dl[@class = 'item-options']/dd[1]")
    WebElement size;

    @FindBy(xpath = "//tr[contains(@id,'order-item-row-')]//dl[@class = 'item-options']/dd[2]")
    WebElement color;

    @FindBy(xpath = "//tr[@class = 'subtotal']/td[@class = 'amount']/span")
    private WebElement subTotal;

    @FindBy(xpath = "//tr[@class = 'shipping']/td[@class = 'amount']/span")
    private WebElement shippingcost;

    @FindBy(xpath = "//tr[@class = 'grand_total']//span[@class = 'price']")
    private WebElement grandTotal;



    public ProductPage chooseProductToBuy(){

        click(menLink,10);
        click(jacketLink,10);
        click(montanaJacket,10);
        return new ProductPage(driver);
    }

    public String getProductName(){
        return getText(productItemName);
    }

    public String getProductSubtotal(){
        return getText(subTotal);
    }

    public String getProductShipping(){
        return getText(shippingcost);
    }

    public String getGrandTotal(){
        return getText(grandTotal);
    }

    public String getSize(){
        return getText(size);
    }

    public String getColor(){
        return getText(color);
    }
}


