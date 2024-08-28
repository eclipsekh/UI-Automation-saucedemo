package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class listingPage {

    private WebDriver driver;
    private By addToCartButton = By.xpath("//button[@class='btn_primary btn_inventory']");
    private By removeItemButton = By.xpath("//button[@class='btn_secondary btn_inventory']");
    private By cartButton = By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']");


    public listingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public int checkItemsAdded(){
        int itemsAddedCount = driver.findElements(removeItemButton).size();

        return itemsAddedCount;
    }

    public void addToCart(){
        driver.findElements(addToCartButton).get(0).click();
        driver.findElements(addToCartButton).get(1).click();
    }

    public cartPage navigateToCart(){
        driver.findElement(cartButton).click();

        return new cartPage(driver);
    }

}
