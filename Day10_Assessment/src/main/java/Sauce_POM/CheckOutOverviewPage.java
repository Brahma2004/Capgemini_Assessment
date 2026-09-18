package Sauce_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {
    WebDriver driver;

    public CheckOutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement overviewTitle;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement orderMessage;

    public boolean overviewDisplayed(String value) {
        return overviewTitle.getText().equals(value);
    }

    public void clickFinish() {
        finishButton.click();
    }

    public String getOrderMessage() {
        return orderMessage.getText();
    }
}