package ORANGE_POM_2;

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

    @FindBy(className = "oxd-userdropdown-tab")
    private WebElement profile;

    @FindBy(xpath = "//a[contains(@href,'/auth/logout')]")
    private WebElement logout;

    public void clickProfile() {
        profile.click();
    }

    public void clickLogout() {
        logout.click();
    }

    public void logout() {
        clickProfile();
        clickLogout();
    }
}