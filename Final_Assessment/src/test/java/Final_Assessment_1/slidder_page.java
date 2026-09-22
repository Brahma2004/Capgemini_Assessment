//package Final_Assessment_1;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class slidder_page {
//
//	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//
//		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
//		Thread.sleep(2000);
//
//		WebElement slider = driver.findElement(By.id("slide"));
//		slider.click();
//		slider.sendKeys(Keys.HOME);
//		slider.sendKeys(Keys.ARROW_RIGHT);
//		slider.sendKeys(Keys.ARROW_RIGHT);
//		slider.sendKeys(Keys.ARROW_RIGHT);
//		Thread.sleep(1000);
//		
//		if (driver.getPageSource().contains("Mens Cotton Jacket")) {
//			System.out.println("PASS: Mens Cotton Jacket is displayed");
//		} else {
//			System.out.println("FAIL: Mens Cotton Jacket is not displayed");
//		}
//
//		driver.quit();
//	}
//}
package Final_Assessment_1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class slidder_page {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		WebElement slider = driver.findElement(By.id("slide"));
		Actions a = new Actions(driver);
		a.clickAndHold(slider).moveByOffset(300, 0).release().perform();
		WebElement jacket = driver.findElement(By.xpath("//*[contains(text(),'Mens Cotton Jacket')]"));
		if(jacket.isDisplayed()) {
			System.out.println("Mens Cotton Jacket is displayed");
		}
		driver.quit();
	}
}
