package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class listingPage {

    private WebDriver driver;
    private By itemOne = By.id("add-to-cart-sauce-labs-backpack");
    private By itemTwo = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeItemOne = By.id("remove-sauce-labs-backpack");
    private By removeItemTwo = By.id("remove-sauce-labs-bike-light");
    private By cartButton = By.xpath("//a[@class='shopping_cart_link']");


    public listingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String checkItemOneAdded(){
        String itemOneText = driver.findElement(removeItemOne).getText();

        return itemOneText;
    }

    public String checkItemTwoAdded(){
        String itemTwoText = driver.findElement(removeItemTwo).getText();

        return itemTwoText;
    }


    public void addToCart(){
        driver.findElement(itemOne).click();
        driver.findElement(itemTwo).click();
    }

    public cartPage navigateToCart(){
        driver.findElement(cartButton).click();

        return new cartPage(driver);
    }

}
