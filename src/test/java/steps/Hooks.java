package steps;

import Managers.ConfigManager;
import Managers.DriverManager;
import com.google.common.net.MediaType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.GenerateUsers;
import utils.Log;


public class Hooks extends TestBase {

    @Before
    public void setUp() {
        if (prop == null)
            Log.info("Reading Properties file");
            prop = ConfigManager.readConfig();

        if (user == null)
            Log.info("Generating user info from rest endpoint");
            user = GenerateUsers.getUserData();

        if (driver == null) {
            Log.info("Initializing WebDriver session for  " + prop.getProperty("browser") + " browser");
            driver = DriverManager.initDriver(prop.getProperty("browser"));
            Log.info("Maximizing browser window");
            driver.manage().window().maximize();
        }

    }

    @After
    public void teardown(Scenario scenario) {

        if (scenario.isFailed()) {

            Log.info("Taking page screenshot as scenario " + scenario.getName() + " has failed");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Log.info("Attaching Page ScreenShot to Cucumber test reports");
            scenario.attach(screenshot, String.valueOf(MediaType.PNG), scenario.getName());

        }
        if (driver != null) {
            Log.info("quitting Selenium WebDriver Session");
            driver.quit();
        }

    }
}
