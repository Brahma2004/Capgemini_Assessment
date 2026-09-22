package Orange_SCRIPT;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BASE_ORANGE.ORangeBAse;
import Or_POM.BuzzPage;
import Or_POM.LoginPage;
import Utilities.Excel_Orange;

public class OrangeHRMBuzzTest extends ORangeBAse {

    @Test
    public void orangeHRMBuzzTest() throws IOException {

        LoginPage lp = new LoginPage(driver);

        lp.login("Admin", "admin123");

        BuzzPage bp = new BuzzPage(driver);

        bp.clickBuzz();

        Excel_Orange excel = new Excel_Orange();

        String message = excel.getData();

        System.out.println("Message from Excel: " + message);

        bp.enterPost(message);

        bp.clickPost();

        boolean result = bp.verifyPost(message);

        Assert.assertTrue(
                result,
                "Post is not displayed in Recent Posts"
        );

        System.out.println("Post is displayed in Recent Posts");

        bp.logout();

        System.out.println("Logout Successfully");
    }
}