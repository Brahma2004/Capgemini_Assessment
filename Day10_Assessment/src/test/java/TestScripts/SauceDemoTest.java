package TestScripts;

import org.testng.annotations.Test;
import org.testng.Reporter;
import Baseclass.BaseTest;
import Sauce_POM.CartPage;
import Sauce_POM.CheckOutOverviewPage;
import Sauce_POM.CheckOutPage;
import Sauce_POM.ProductsPage;

public class SauceDemoTest extends BaseTest {

    @Test
    public void loginTest() {
        ProductsPage pp = new ProductsPage(driver);
        if (pp.productsDisplayed(productsTitle)) {
            Reporter.log("Products page is displayed", true);
        } else {
            Reporter.log("Products page is not displayed", true);
        }
    }

    @Test
    public void orderPlacementTest() {
        ProductsPage pp = new ProductsPage(driver);
        pp.addProduct(product);

        if (pp.getCartCount().equals(cartCount)) {
            Reporter.log("Cart contains 1 item", true);
        } else {
            Reporter.log("Cart does not contain 1 item", true);
        }

        pp.clickCart();

        CartPage cp = new CartPage(driver);

        if (cp.productDisplayed(product)) {
            Reporter.log("Sauce Labs Backpack is displayed in cart", true);
        } else {
            Reporter.log("Sauce Labs Backpack is not displayed in cart", true);
        }

        cp.clickCheckout();

        CheckOutPage cop = new CheckOutPage(driver);
        cop.enterFirstName("Brahma");
        cop.enterLastName("K");
        cop.enterPostalCode("515001");
        cop.clickContinue();

        CheckOutOverviewPage chk = new CheckOutOverviewPage(driver);

        if (chk.overviewDisplayed(overviewTitle)) {
            Reporter.log("Checkout: Overview page is displayed", true);
        } else {
            Reporter.log("Checkout: Overview page is not displayed", true);
        }

        chk.clickFinish();

        if (chk.getOrderMessage().equals(orderMessage)) {
            Reporter.log("Thank you for your order!", true);
        } else {
            Reporter.log("Order confirmation message is not displayed", true);
        }
    }
}