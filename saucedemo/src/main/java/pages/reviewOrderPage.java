package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class reviewOrderPage {

    private WebDriver driver;
    private By finish = By.id("finish");



    public reviewOrderPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public confirmationOrderPage placeOrder(){

        driver.findElement(finish).click();

        return new confirmationOrderPage(driver);

    }
}
