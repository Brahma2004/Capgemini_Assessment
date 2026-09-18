package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMCandidate {

	WebDriver driver;

	public POMCandidate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Candidates']")
	private WebElement Cbutton;

	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	private WebElement Jtite;

	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	private WebElement Vac;

	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[3]")
	private WebElement HireM;

	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[4]")
	private WebElement status;

	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement Cname;

	@FindBy(xpath="//input[@placeholder='From']")
	private WebElement From;

	@FindBy(xpath="//input[@placeholder='To']")
	private WebElement To;

	@FindBy(xpath="//button[normalize-space()='Search']")
	private WebElement Search;

	@FindBy(xpath="//span[contains(@class,'oxd-userdropdown-tab')]")
	private WebElement userMenu;

	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement Logout;

	public void getCbutton() throws InterruptedException {
		Thread.sleep(2000);
		Cbutton.click();
	}

	public void getJtite() throws InterruptedException {
		Jtite.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@role='option' and normalize-space()!='-- Select --'])[1]")).click();
	}

	public void getVac() throws InterruptedException {
		Vac.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@role='option' and normalize-space()!='-- Select --'])[1]")).click();
	}

	public void getHireM() throws InterruptedException {
		HireM.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@role='option' and normalize-space()!='-- Select --'])[1]")).click();
	}

	public void getStatus() throws InterruptedException {
		status.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@role='option' and normalize-space()!='-- Select --'])[1]")).click();
	}

	public void getCname(String value) throws InterruptedException {
		Cname.click();
		Cname.sendKeys(value);
		Thread.sleep(1000);
		Cname.sendKeys(Keys.TAB);
	}

	public void getFrom(String value) {
		From.click();
		From.sendKeys(Keys.CONTROL, "a");
		From.sendKeys(Keys.BACK_SPACE);
		From.sendKeys(value);
		From.sendKeys(Keys.TAB);
	}

	public void getTo(String value) {
		To.click();
		To.sendKeys(Keys.CONTROL, "a");
		To.sendKeys(Keys.BACK_SPACE);
		To.sendKeys(value);
		To.sendKeys(Keys.TAB);
	}

	public void getSearch() throws InterruptedException {
		Thread.sleep(1000);
		Search.click();
	}

	public String getRv(String value) {
		return driver.findElement(By.xpath("//div[contains(@class,'oxd-table-body')]//div[contains(@class,'oxd-table-row')][.//*[contains(normalize-space(),'" + value + "')]]")).getText();
	}

	public void getLogout() {
		userMenu.click();
		Logout.click();
	}
}