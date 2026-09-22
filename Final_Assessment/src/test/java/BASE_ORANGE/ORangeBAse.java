package BASE_ORANGE;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ORangeBAse {

    protected WebDriver driver;

    @BeforeMethod
    public void PreConditions() {

        System.out.println("Pre Conditions");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        System.out.println("Launched Browser Successfully");
    }

    @AfterMethod
    public void PostConditions() {

        System.out.println("Post Conditions");

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}