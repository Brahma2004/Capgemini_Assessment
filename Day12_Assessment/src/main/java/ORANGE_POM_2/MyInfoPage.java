package ORANGE_POM_2;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfoPage {

    WebDriver driver;
    WebDriverWait wait;

    public MyInfoPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'viewMyDetails')]")
    private WebElement myInfo;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "//label[text()='Employee Id']/../..//input")
    private WebElement employeeId;

    @FindBy(xpath = "//label[normalize-space()='Male']/span")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(className = "oxd-form-loader")
    private WebElement formLoader;


    public void clickMyInfo() {

        wait.until(ExpectedConditions.elementToBeClickable(myInfo));

        myInfo.click();

        wait.until(ExpectedConditions.visibilityOf(firstName));

        wait.until(ExpectedConditions.invisibilityOf(formLoader));
    }


    public void enterFirstName(String value) {

        wait.until(ExpectedConditions.invisibilityOf(formLoader));

        wait.until(ExpectedConditions.visibilityOf(firstName));

        new Actions(driver)
                .scrollToElement(firstName)
                .perform();

        wait.until(ExpectedConditions.elementToBeClickable(firstName));

        firstName.click();

        firstName.sendKeys(Keys.CONTROL, "a");
        firstName.sendKeys(Keys.BACK_SPACE);
        firstName.sendKeys(value);
    }


    public void enterLastName(String value) {

        wait.until(ExpectedConditions.invisibilityOf(formLoader));

        wait.until(ExpectedConditions.visibilityOf(lastName));

        new Actions(driver).scrollToElement(lastName).perform();

        wait.until(ExpectedConditions.elementToBeClickable(lastName));

        lastName.click();

        lastName.sendKeys(Keys.CONTROL, "a");
        lastName.sendKeys(Keys.BACK_SPACE);
        lastName.sendKeys(value);
    }


    public void enterEmployeeId(String value) {

        wait.until(ExpectedConditions.invisibilityOf(formLoader));

        wait.until(ExpectedConditions.visibilityOf(employeeId));

        new Actions(driver).scrollToElement(employeeId).perform();

        wait.until(ExpectedConditions.elementToBeClickable(employeeId));

        employeeId.click();

        employeeId.sendKeys(Keys.CONTROL, "a");
        employeeId.sendKeys(Keys.BACK_SPACE);
        employeeId.sendKeys(value);
    }


    public void selectMale() {

        wait.until(ExpectedConditions.invisibilityOf(formLoader));

        wait.until(ExpectedConditions.elementToBeClickable(maleRadioButton));

        maleRadioButton.click();
    }


    public void clickSave() {

        wait.until(ExpectedConditions.invisibilityOf(formLoader));

        new Actions(driver)
                .scrollToElement(saveButton)
                .perform();

        wait.until(ExpectedConditions.elementToBeClickable(saveButton));

        saveButton.click();

        wait.until(ExpectedConditions.invisibilityOf(formLoader));
    }


    public String getFirstName() {

        wait.until(ExpectedConditions.invisibilityOf(formLoader));

        wait.until(ExpectedConditions.visibilityOf(firstName));

        return firstName.getAttribute("value");
    }


    public String getLastName() {

        wait.until(ExpectedConditions.invisibilityOf(formLoader));

        wait.until(ExpectedConditions.visibilityOf(lastName));

        return lastName.getAttribute("value");
    }


    public String getEmployeeId() {

        wait.until(ExpectedConditions.invisibilityOf(formLoader));

        wait.until(ExpectedConditions.visibilityOf(employeeId));

        return employeeId.getAttribute("value");
    }
}