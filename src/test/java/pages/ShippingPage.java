package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.TestBase;

import static actions.ActionWebElements.*;

public class ShippingPage extends TestBase {

    public ShippingPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "street[0]")
    private WebElement street;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "postcode")
    private WebElement zip;

    @FindBy(name = "country_id")
    private WebElement country;

    @FindBy(name = "region_id")
    private WebElement state;

    @FindBy(name = "telephone")
    private WebElement phone;

    @FindBy(xpath = "//table[@class = 'table-checkout-shipping-method']/tbody/tr[1]/td[1]")
    private WebElement shipping;

    @FindBy(xpath = "//div[@id = 'shipping-method-buttons-container']//button")
    private WebElement next;

    @FindBy(xpath = "//button[@title = 'Place Order']")
    private WebElement placeOrder;

    @FindBy(xpath = "//a[@class = 'order-number']")
    private WebElement ordernumber;

    @FindBy(className = "loading-mask")
    private WebElement loader;

    public void enterShippingDetails(String country,String state,String city,String street,String zip,String phone)  {

        selectByVisibleText(this.country,country,10);
        invisibilityOfEle(loader,10);
        selectByVisibleText(this.state,state,10);
        sendKeys(this.city,city,10);
        sendKeys(this.street,street,10);
        sendKeys(this.zip,zip,10);
        sendKeys(this.phone,phone,10);
        click(shipping,10);
        scrollToElement(next);
        click(next,10);
    }

   public AccountPage placeOrder(){

        invisibilityOfEle(loader,10);
        click(placeOrder,10);
        click(ordernumber,10);
        return new AccountPage(driver);
    }

}
