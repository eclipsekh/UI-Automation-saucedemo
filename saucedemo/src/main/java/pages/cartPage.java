package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage {

    private WebDriver driver;
    private By removeItemButton = By.xpath("//button[@class='btn_secondary cart_button']");
    private By checkoutButton = By.xpath("//a[@class='btn_action checkout_button']");
    private By itemsCount = By.className("cart_item");


    public cartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }


    public void removeItemFromCart(){
        driver.findElements(removeItemButton).get(0).click();
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
