package Managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public static WebDriver initDriver(String browser) {

        WebDriver driver;

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized"); // open Browser in maximized mode
                options.addArguments("disable-infobars"); // disabling infobars
                options.addArguments("--disable-extensions"); // disabling extensions
                options.addArguments("--disable-gpu"); // applicable to windows os only
                options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                options.addArguments("--no-sandbox"); // Bypass OS security model
                WebDriver driver = new ChromeDriver(options);
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser Not Supported!!");
        }
        return driver;
    }
}
