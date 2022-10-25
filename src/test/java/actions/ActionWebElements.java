package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;
import steps.TestBase;

import java.time.Duration;

public class ActionWebElements extends TestBase {

    public static void click(final WebElement element, final long time)
    {
        Log.info("Before clicking on element " + element);
        clickable(element,time).click();
    }

    public static void sendKeys(final WebElement element, final String key, final long time)
    {
        Log.info("Sending value " + key + " to element " + element);
        clickable(element,time).sendKeys(key);
    }

    public static String getText(final WebElement element){
        return element.getText();
    }

    public static Object getAttributeValue(final WebElement element,final String attributeName){

         Log.info("Wait for visibility of element " + element);
         return visibilityOf(element,10).getAttribute(attributeName);

    }

    public static void selectByVisibleText(final WebElement element, final String option,final long time)
    {
        Log.info("Select visible option " + option + " from element " + element);
        WebElement ele  = visibilityOf(element,time);
        Select select = new Select(ele);
        select.selectByVisibleText(option);
    }

    public static void scrollToElement(final WebElement element){

        Log.info("Scrolling till visibility of element " + element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static  WebElement visibilityOf(final WebElement element,final long time)
    {
          Log.info("Waiting till visibilily of element " + element);
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
          wait.until(ExpectedConditions.visibilityOf(element));
          return element;
    }

    public static  WebElement invisibilityOfEle(final WebElement element,final long time)
    {
        Log.info("Waiting for invisibility of element " + element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public static WebElement  clickable(WebElement element, long time){

        Log.info("Validating that element " + element + " is clickable");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
