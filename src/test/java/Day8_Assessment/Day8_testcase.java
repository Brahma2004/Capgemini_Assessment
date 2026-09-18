package Day8_Assessment;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.POMAddpage;
import POM.POMCandidate;
import POM.POMLogin;
import POM.POMRecruitment;

public class Day8_testcase {

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {

		// Read Properties File

		FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\DDT\\HRM.Properties");

		Properties p = new Properties();
		p.load(fil);

		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String uname = p.getProperty("username");
		String pass = p.getProperty("password");

		// Read Excel File

		FileInputStream xl = new FileInputStream(".\\src\\test\\resources\\DDT\\HRM.xlsx");

		Workbook wb = WorkbookFactory.create(xl);

		String Fname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String Mname = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String Lname = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String email = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		String res = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String cname = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();

		// Launch Browser

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(url);

		// Login

		POMLogin p1 = new POMLogin(driver);

		p1.getUname(uname);
		p1.getPass(pass);
		p1.getLogin();

		// Recruitment

		POMRecruitment p2 = new POMRecruitment(driver);

		p2.getRbutton();
		p2.getAdd();

		// Add Candidate

		POMAddpage p3 = new POMAddpage(driver);

		p3.getFname(Fname);
		p3.getMname(Mname);
		p3.getLname(Lname);
		p3.getVacy();
		p3.getEmail(email);
		p3.getCno("7829482981");
		p3.getResume1(res);

		Thread.sleep(3000);

		p3.getSave();

		Thread.sleep(3000);

		// Candidates

		POMCandidate p4 = new POMCandidate(driver);

		p4.getCbutton();

		// Select Filters

		p4.getJtite();
		p4.getVac();
		p4.getHireM();
		p4.getStatus();

		// Enter Candidate Name

		p4.getCname(cname);

		// Application Date

		p4.getFrom("2026-01-09");
		p4.getTo("2026-18-09");

		// Search

		p4.getSearch();

		Thread.sleep(3000);

		// Verify Candidate

		String result = p4.getRv(cname);

		if (result.contains(cname)) {
			System.out.println(cname);
			System.out.println("Candidate Found: " + cname);
		} else {
			System.out.println("Candidate Not Found");
		}

		// Logout

		p4.getLogout();

		System.out.println("Logout successful");

		// Close Browser

		driver.quit();

		fil.close();
		xl.close();
		wb.close();
	}
}