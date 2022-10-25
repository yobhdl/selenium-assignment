package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pages.*;
import utils.Log;

import java.util.Random;

public class BuyProductSteps extends TestBase {

    private HomePage homepage;
    private RegistrationPage registrationPage;
    private AccountPage accountpage;
    private ProductPage productpage;
    private ShippingPage shippingpage;

    @Given("user navigates to registration page")
    public void user_navigates_to_registration_page() {
        Log.info("Launching the url  " + prop.getProperty("url"));
        driver.get(prop.getProperty("url"));
        homepage = new HomePage(driver);
        Log.info("Navigating to Registration page");
        registrationPage = homepage.navToCreateAccPage();
    }

    @When("user registers with user information")
    public void user_registers_with_user_information() {

        String fname = user.results.get(0).getName().getFirst() + RandomStringUtils.randomAlphabetic(3);
        String lname = user.results.get(0).getName().getLast();
        String email = user.results.get(0).getEmail();
        String passwd = user.results.get(0).getLogin().getPassword();
        String confirmpasswd = user.results.get(0).getLogin().getPassword();

        Log.info("Registering user with user information" + fname + ", " + lname + ", " + email + ", " + passwd + ", " + confirmpasswd);
        accountpage = registrationPage.userRegistration(fname, lname, email, passwd, confirmpasswd);
    }

    @When("user buy montana jacket")
    public void user_buy_montana_jacket() {

        Log.info("Choosing montana jacket to buy");
        productpage = accountpage.chooseProductToBuy();

        Log.info("Adding the product to cart");
        productpage.addProductToCart();

        Log.info("Checking out the product");
        shippingpage = productpage.checkoutProduct();

        String country = user.getResults().get(0).getLocation().getCountry();
        String state = user.getResults().get(0).getLocation().getState();
        String city = user.getResults().get(0).getLocation().getCity();
        String street = user.getResults().get(0).getLocation().getStreet().getName();
        String zip = user.getResults().get(0).getLocation().getPostcode();
        String phone = user.getResults().get(0).getPhone();
        Log.info("Enter Shipping details");
        shippingpage.enterShippingDetails(country, state, city, street, zip, phone);
        Log.info("Placing the order");
        accountpage = shippingpage.placeOrder();
    }

    @Then("order is placed successfully")
    public void order_is_placed_successfully() {

        Log.info("Asserting product information");
        Assert.assertEquals(accountpage.getProductName(), "Montana Wind Jacket");
        Assert.assertEquals(accountpage.getSize(), "XL");
        Assert.assertEquals(accountpage.getColor(), "Black");
        Assert.assertEquals(accountpage.getProductSubtotal(), "$49.00");
        Assert.assertEquals(accountpage.getProductShipping(), "$5.00");
        Assert.assertEquals(accountpage.getGrandTotal(), "$54.00");

    }
}
