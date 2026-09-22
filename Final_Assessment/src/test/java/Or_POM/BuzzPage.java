package Or_POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuzzPage {

    WebDriver driver;
    WebDriverWait wait;

    public BuzzPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Buzz']")
    WebElement buzzLink;

    @FindBy(xpath = "//textarea[@placeholder=\"What's on your mind?\"]")
    WebElement postTextBox;

    @FindBy(xpath = "//button[normalize-space()='Post']")
    WebElement postButton;

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    WebElement profileDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutButton;

    public void clickBuzz() {

        wait.until(
                ExpectedConditions.elementToBeClickable(buzzLink)
        );

        buzzLink.click();
    }

    public void enterPost(String message) {

        wait.until(
                ExpectedConditions.visibilityOf(postTextBox)
        );

        postTextBox.sendKeys(message);
    }

    public void clickPost() {

        wait.until(
                ExpectedConditions.elementToBeClickable(postButton)
        );

        postButton.click();
    }

    public boolean verifyPost(String message) {

        try {

            WebElement postedMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "//*[contains(normalize-space(),\"" + message + "\")]"
                            )
                    )
            );

            return postedMessage.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public void logout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(profileDropdown)
        );

        profileDropdown.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(logoutButton)
        );

        logoutButton.click();
    }
}