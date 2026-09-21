package Base_Class_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base_Test_2 {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected String username;
    protected String password;
    protected String url;

    @BeforeSuite
    public void BS() {
        System.out.println("Open Database Connectivity");
    }

    @BeforeTest
    public void BT() {
        System.out.println("Pre-Conditions");
    }

    @BeforeClass
    public void BC() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Launch Browser");
    }

    @BeforeMethod
    public void BM() throws IOException {

        Properties prop = new Properties();

        FileInputStream fis =new FileInputStream("./src/main/resources/Common_Data.properties");

        prop.load(fis);
        fis.close();

        username = prop.getProperty("username");
        password = prop.getProperty("password");
        url = prop.getProperty("url");

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);

        System.out.println("Application Launched");
    }

    @AfterMethod
    public void AM() {
        System.out.println("Test Completed");
    }

    @AfterClass
    public void AC() {
        driver.quit();
        System.out.println("Close Browser");
    }

    @AfterTest
    public void AT() {
        System.out.println("Post-Conditions");
    }

    @AfterSuite
    public void AS() {
        System.out.println("Close Database Connectivity");
    }
}