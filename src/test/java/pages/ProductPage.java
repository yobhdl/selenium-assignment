package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steps.TestBase;

import static actions.ActionWebElements.click;
import static actions.ActionWebElements.invisibilityOfEle;

public class ProductPage extends TestBase {

    public ProductPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "option-label-size-143-item-170")
    private WebElement xlsize;

    @FindBy(id = "option-label-color-93-item-49")
    private WebElement blkcolor;

    @FindBy(id = "qty")
    private WebElement quantity;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement addtocartbutton;

    @FindBy(xpath = "//a[contains(@class,'action showcart')]")
    private WebElement cart;

    @FindBy(xpath = "//span[@class = 'counter-number']")
    private WebElement cartCounter;

    @FindBy(xpath = "//button[text()='Proceed to Checkout']")
    private WebElement checkoutbtn;

    @FindBy(xpath = "//div[@class = 'loading-mask']")
    private WebElement loader;

    public void addProductToCart(){

        click(xlsize,10);
        click(blkcolor,10);
        click(addtocartbutton,10);
}

    public ShippingPage checkoutProduct(){

        invisibilityOfEle(loader,10);
        click(cartCounter,10);
        click(checkoutbtn,10);
        return new ShippingPage(driver);
    }
}