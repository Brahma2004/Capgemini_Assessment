package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMAddpage {

	WebDriver driver;

	public POMAddpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='firstName']")
	private WebElement Fname;

	@FindBy(xpath="//input[@name='middleName']")
	private WebElement Mname;

	@FindBy(xpath="//input[@name='lastName']")
	private WebElement Lname;

	@FindBy(xpath="//label[normalize-space()='Vacancy']/following::div[contains(@class,'oxd-select-text')][1]")
	private WebElement vacy;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement email;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement Cno;

	@FindBy(xpath="//input[@type='file']")
	private WebElement Resume1;

	@FindBy(xpath="//input[@placeholder='yyyy-dd-mm']")
	private WebElement Date;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement Save;

	public void getFname(String value) {
		Fname.sendKeys(value);
	}

	public void getMname(String value) {
		Mname.sendKeys(value);
	}

	public void getLname(String value) {
		Lname.sendKeys(value);
	}

	public void getVacy() throws InterruptedException {

		vacy.click();

		Thread.sleep(1000);

		for (int i = 0; i < 3; i++) {
			try {
				driver.findElement(By.xpath("//div[@role='option' and normalize-space()!='-- Select --']")).click();
				break;
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				Thread.sleep(500);
			}
		}

		Thread.sleep(1000);
	}

	public String getSelectedVacancy() {
		return vacy.getText();
	}

	public void getEmail(String value) {
		email.sendKeys(value);
	}

	public void getCno(String value) {
		Cno.sendKeys(value);
	}

	public void getResume1(String value) {
		Resume1.sendKeys(value);
	}

	public void getDate(String value) {
		Date.click();
		Date.sendKeys(Keys.CONTROL, "a");
		Date.sendKeys(Keys.BACK_SPACE);
		Date.sendKeys(value);
		Date.sendKeys(Keys.TAB);
	}

	public void getSave() {
		Save.click();
	}
}