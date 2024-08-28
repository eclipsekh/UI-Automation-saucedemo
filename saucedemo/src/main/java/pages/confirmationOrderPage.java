package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class confirmationOrderPage {

    private WebDriver driver;
    private By confirmationMessage = By.xpath("//h2[@class='complete-header']");


    public confirmationOrderPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String checkSuccessMessage(){
        String message = driver.findElement(confirmationMessage).getText();

        return message;
    }



}
