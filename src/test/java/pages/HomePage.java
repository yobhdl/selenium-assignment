package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.TestBase;

import static actions.ActionWebElements.click;

public class HomePage extends TestBase {

   public HomePage(WebDriver driver){

       PageFactory.initElements(driver,this);
   }

    @FindBy(linkText = "Create an Account")
    private WebElement createAccLink;

   public RegistrationPage navToCreateAccPage(){

       click(createAccLink,10);
       return new RegistrationPage(driver);
   }
}


