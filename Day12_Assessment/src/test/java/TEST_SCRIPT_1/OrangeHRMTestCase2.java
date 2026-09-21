package TEST_SCRIPT_1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base_Class_2.Base_Test_2;
import ORANGE_POM_2.HomePage;
import ORANGE_POM_2.LoginPage;
import ORANGE_POM_2.MyInfoPage;
import Utilities_1.ExcelUtility_1;

public class OrangeHRMTestCase2 extends Base_Test_2 {

    @Test
    public void verifyEmployeeDetailsUpdate() throws IOException {

        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        MyInfoPage mp = new MyInfoPage(driver);

        String firstName =ExcelUtility_1.getExcelData("Sheet1", 1, 0);

        String lastName =ExcelUtility_1.getExcelData("Sheet1", 1, 1);

        String employeeId =ExcelUtility_1.getExcelData("Sheet1", 1, 2);

        Reporter.log("Login to OrangeHRM", true);

        lp.login(username, password);

        Reporter.log("Login Completed", true);

        Reporter.log("Click My Info", true);

        mp.clickMyInfo();

        Reporter.log("Update First Name", true);

        mp.enterFirstName(firstName);

        Reporter.log("Update Last Name", true);

        mp.enterLastName(lastName);

        Reporter.log("Update Employee ID", true);

        mp.enterEmployeeId(employeeId);

        Reporter.log("Select Male", true);

        mp.selectMale();

        Reporter.log("Click Save", true);

        mp.clickSave();

        Reporter.log("Employee Details Saved", true);

        Reporter.log("Logout", true);

        hp.logout();

        Reporter.log("Login Again", true);

        lp.login(username, password);

        Reporter.log("Second Login Completed", true);

        Reporter.log("Click My Info Again", true);

        mp.clickMyInfo();

        Reporter.log("Verify First Name", true);

        String actualFirstName = mp.getFirstName();

        System.out.println("Expected First Name: " + firstName);
        System.out.println("Actual First Name: " + actualFirstName);

        Assert.assertEquals(actualFirstName, firstName);

        Reporter.log("Verify Last Name", true);

        String actualLastName = mp.getLastName();

        System.out.println("Expected Last Name: " + lastName);
        System.out.println("Actual Last Name: " + actualLastName);

        Assert.assertEquals(actualLastName, lastName);

        Reporter.log("Verify Employee ID", true);

        String actualEmployeeId = mp.getEmployeeId();

        System.out.println("Expected Employee ID: " + employeeId);
        System.out.println("Actual Employee ID: " + actualEmployeeId);

        Assert.assertEquals(actualEmployeeId, employeeId);

        Reporter.log("Employee Details Updated Successfully", true);

        Reporter.log("Final Logout", true);

        hp.logout();
    }
}