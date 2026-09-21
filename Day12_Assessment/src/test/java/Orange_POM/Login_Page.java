package Orange_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {

    WebDriver driver;
    WebDriverWait wait;

    public Login_Page(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public void enterUsername(String user) {

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
    }

    public void enterPassword(String pass) {

        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
    }

    public void clickLogin() {

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void login(String user, String pass) {

        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}