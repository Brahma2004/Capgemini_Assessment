package Sauce_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public boolean productDisplayed(String product) {
        return driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText().equals(product);
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}