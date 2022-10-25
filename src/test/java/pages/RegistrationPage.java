package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.TestBase;

import static actions.ActionWebElements.click;
import static actions.ActionWebElements.sendKeys;

public class RegistrationPage extends TestBase {

    public RegistrationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "email_address")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private WebElement createAccSubmit;

    public AccountPage userRegistration(String fname, String lName, String emailid,String passwd, String confirmPasswd){

        sendKeys(firstName,fname,10);
        sendKeys(lastName,lName,10);
        sendKeys(email,emailid,10);
        sendKeys(password,passwd,10);
        sendKeys(confirmPassword,confirmPasswd,10);
        click(createAccSubmit,10);
        return new AccountPage(driver);
    }

}
