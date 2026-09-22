package Orange_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddVacancyPage {
    WebDriver driver;
    WebDriverWait wait;
    public AddVacancyPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//label[text()='Vacancy Name']/../following-sibling::div//input")
    private WebElement vacancyName;
    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
    private WebElement jobTitleDropdown;
    @FindBy(xpath = "//textarea")
    private WebElement description;
    @FindBy(xpath = "//label[text()='Hiring Manager']/../following-sibling::div//input[@placeholder='Type for hints...']")
    private WebElement hiringManager;
    @FindBy(xpath = "//label[text()='Number of Positions']/../following-sibling::div//input")
    private WebElement numberOfPositions;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;
    public void enterVacancyName(String name) {
        wait.until(ExpectedConditions.visibilityOf(vacancyName)).sendKeys(name);
    }
    public void selectJobTitle(String jobTitle) {
        wait.until(ExpectedConditions.elementToBeClickable(jobTitleDropdown)).click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[normalize-space()='" + jobTitle + "']")));
        option.click();
    }
    public void enterDescription(String text) {
        wait.until(ExpectedConditions.visibilityOf(description)).sendKeys(text);
    }
    public void selectHiringManager(String manager) {
        wait.until(ExpectedConditions.visibilityOf(hiringManager)).sendKeys(manager);
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[normalize-space()='" + manager + "']")));
        option.click();
    }
    public void enterNumberOfPositions(String number) {
        wait.until(ExpectedConditions.visibilityOf(numberOfPositions)).sendKeys(number);
    }
    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}