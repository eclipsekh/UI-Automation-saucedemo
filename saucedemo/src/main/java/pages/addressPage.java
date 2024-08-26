package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addressPage {

    private WebDriver driver;
    private By addressFirstName = By.id("first-name");
    private By addressLastName = By.id("last-name");
    private By addressZipCode = By.id("postal-code");
    private By continueButton = By.id("continue");



    public addressPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public reviewOrderPage createAddress(String firstName, String lastName, String zipCode){

        driver.findElement(addressFirstName).sendKeys(firstName);
        driver.findElement(addressLastName).sendKeys(lastName);
        driver.findElement(addressZipCode).sendKeys(zipCode);
        driver.findElement(continueButton).click();

        return new reviewOrderPage(driver);

    }
}
