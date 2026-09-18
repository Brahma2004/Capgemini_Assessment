package Baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import Sauce_POM.LoginPage;
import Sauce_POM.LogoutPage;

public class BaseTest {
    protected WebDriver driver;
    protected String url;
    protected String browser;
    protected String username;
    protected String password;
    protected String product;
    protected String productsTitle;
    protected String cartCount;
    protected String overviewTitle;
    protected String orderMessage;

    @BeforeSuite
    public void DataBaseEstablishment() {
        Reporter.log("DataBase Connectivity Established", true);
    }

    @BeforeTest
    public void BT() {
        Reporter.log("Pre Conditions", true);
    }

    @BeforeClass
    public void CrossBrowserTest() throws IOException {
        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Sauce_Data.Properties");
        Properties prop = new Properties();
        prop.load(fis);
        fis.close();

        url = prop.getProperty("url");
        browser = prop.getProperty("browser");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        product = prop.getProperty("product");
        productsTitle = prop.getProperty("productsTitle");
        cartCount = prop.getProperty("cartCount");
        overviewTitle = prop.getProperty("overviewTitle");
        orderMessage = prop.getProperty("orderMessage");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_leak_detection", false);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Reporter.log("Launched Browser Successfully", true);
    }

    @BeforeMethod
    public void LoginTest() {
        driver.get(url);
        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(username);
        lp.enterPassword(password);
        lp.clickLogin();
        Reporter.log("Login Successfully", true);
    }

    @AfterMethod
    public void LogoutTest() {
        LogoutPage lp = new LogoutPage(driver);
        lp.clickMenu();
        lp.clickLogout();
        Reporter.log("Logout Successfully", true);
    }

    @AfterClass
    public void BrowserClosingTest() {
        driver.quit();
        Reporter.log("Browser Closed Successfully", true);
    }

    @AfterTest
    public void AT() {
        Reporter.log("Post Conditions", true);
    }

    @AfterSuite
    public void DataBaseClosing() {
        Reporter.log("DataBase Connectivity Closed", true);
    }
}