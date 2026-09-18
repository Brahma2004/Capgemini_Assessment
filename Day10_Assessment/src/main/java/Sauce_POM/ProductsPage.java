package Sauce_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsTitle;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;

    public boolean productsDisplayed(String value) {
        return productsTitle.getText().equals(value);
    }

    public void addProduct(String product) {
        String xpath = "//div[contains(@class,'inventory_item')][.//div[contains(@class,'inventory_item_name') and text()='" + product + "']]//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getCartCount() {
        return cartBadge.getText();
    }

    public void clickCart() {
        cart.click();
    }
}