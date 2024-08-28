package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    private WebDriver driver;
    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");



    public loginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public listingPage logIn(String name, String pass){
        driver.findElement(userName).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();

        return new listingPage(driver);
    }




}
