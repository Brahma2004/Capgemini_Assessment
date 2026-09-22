package Final_Assessment_1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ShopperStack {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.get("https://www.shoppersstack.com/");
		driver.findElement(By.xpath("//span[text()='iphone']")).click();
		driver.findElement(By.id("Check Delivery")).sendKeys("583101");
		WebElement click=driver.findElement(By.id("Check"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(click));
		click.click();
		String message=driver.findElement(By.id("Check Delivery-helper-text")).getText();
		System.out.println(message);
		
	}
}