package Orange_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage {

    WebDriver driver;
    WebDriverWait wait;

    public RecruitmentPage(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitment;

    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vacancies;

    public void clickRecruitment() {

        wait.until(ExpectedConditions.elementToBeClickable(recruitment)).click();
    }

    public void clickVacancies() {

        wait.until(ExpectedConditions.elementToBeClickable(vacancies)).click();
    }
}