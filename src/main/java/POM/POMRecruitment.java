package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMRecruitment {

    WebDriver driver;

    public POMRecruitment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")
    private WebElement Rbutton;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    private WebElement add;

    public WebDriver getDriver() {
        return driver;
    }

    public void getRbutton() {
        Rbutton.click();
    }

    public void getAdd() {
        add.click();
    }
}