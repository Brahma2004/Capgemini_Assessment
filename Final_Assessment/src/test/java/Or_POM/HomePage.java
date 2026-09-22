package Or_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Buzz']")
    WebElement buzzLink;

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    WebElement profileDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutButton;

    public void clickBuzz() {

        buzzLink.click();
    }

    public void clickProfile() {

        profileDropdown.click();
    }

    public void logout() {

        profileDropdown.click();

        logoutButton.click();
    }
}