package Sauce_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void enterFirstName(String value) {
        firstName.sendKeys(value);
    }

    public void enterLastName(String value) {
        lastName.sendKeys(value);
    }

    public void enterPostalCode(String value) {
        postalCode.sendKeys(value);
    }

    public void clickContinue() {
        continueButton.click();
    }
}