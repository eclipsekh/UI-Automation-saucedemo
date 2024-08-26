package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage {

    private WebDriver driver;
    private By removeFirstItem = By.id("remove-sauce-labs-backpack");
    private By checkoutButton = By.id("checkout");
    private By itemsCount = By.className("cart_item");


    public cartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void removeItem(){
        driver.findElement(removeFirstItem).click();
    }

    public void removeItemFromCart(){
        driver.findElement(removeFirstItem).click();
    }

    public int getCartItemsCount(){
        int count = driver.findElements(itemsCount).size();

        return count;
    }


    public addressPage navigateToAddressPage(){
        driver.findElement(checkoutButton).click();

        return new addressPage(driver);
    }
}
