package MyTests;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.loginPage;
import pages.listingPage;
import pages.cartPage;
import pages.addressPage;
import pages.reviewOrderPage;
import pages.confirmationOrderPage;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class demoTest {

    private WebDriver driver;
    protected loginPage loginPage;
    protected listingPage listingPage;
    protected cartPage cartPage;
    protected addressPage addressPage;
    protected reviewOrderPage reviewOrderPage;
    protected confirmationOrderPage confirmationOrderPage;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/v1/index.html");
        loginPage = new loginPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test (dataProvider = "dp")
    public void sauceTest(String data){
        String user[] = data.split(",");

        // Assert that you are in login page
        String loginURL = loginPage.getUrl();
        Assert.assertEquals(loginURL, "https://www.saucedemo.com/v1/index.html");

        // Login in the system and assert that you are in listing page
        listingPage = loginPage.logIn(user[0], user[1]);
        Assert.assertEquals(listingPage.getUrl(), "https://www.saucedemo.com/v1/inventory.html");

        // add two items in cart and assert that items added successfully
        listingPage.addToCart();
        Assert.assertEquals(listingPage.checkItemsAdded(), 2);


        // Navigate to cart page and assert that you are in cart page & assert that 2 items in cart
        cartPage = listingPage.navigateToCart();
        Assert.assertEquals(cartPage.getUrl(), "https://www.saucedemo.com/v1/cart.html");
        Assert.assertEquals(cartPage.getCartItemsCount(), 2);

        // Remove first item from cart and Assert that there is one item in cart
        cartPage.removeItemFromCart();
        Assert.assertEquals(cartPage.getCartItemsCount(), 1);

        // Navigate to address page and assert that you are in address page
        addressPage = cartPage.navigateToAddressPage();
        Assert.assertEquals(addressPage.getUrl(), "https://www.saucedemo.com/v1/checkout-step-one.html");

        // create address and assert that you in review order page
        reviewOrderPage = addressPage.createAddress("Mahmoud", "Khaifa", "12345");
        Assert.assertEquals(reviewOrderPage.getUrl(), "https://www.saucedemo.com/v1/checkout-step-two.html");

        // place order and assert you are in confirmation page & success message display succssfully
        confirmationOrderPage = reviewOrderPage.placeOrder();
        Assert.assertEquals(confirmationOrderPage.getUrl(), "https://www.saucedemo.com/v1/checkout-complete.html");
        Assert.assertEquals(confirmationOrderPage.checkSuccessMessage(), "THANK YOU FOR YOUR ORDER");


    }

    @DataProvider(name="dp")
    public String [] readJson() throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader("jsonFile/loginData.json");
        Object obj = jsonParser.parse(reader);
        JsonObject userLogins = (JsonObject) obj;
        JsonArray userLoginArray = (JsonArray)userLogins.get("userlogins");
        String arr[] = new String[userLoginArray.size()];

        for(int i=0; i<userLoginArray.size(); i++){
            JsonObject jObject = (JsonObject)userLoginArray.get(i);
            String user = jObject.get("username").getAsString();
            String password = jObject.get("password").getAsString();
            arr[i] = user + "," + password;
        }

        return arr;
    }
}
