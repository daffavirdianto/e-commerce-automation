package selenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.LoginPage;
import com.automation.pages.Page;
import com.automation.pages.PaymentDonePage;
import com.automation.pages.PaymentPage;
import com.automation.pages.ProductDetailPage;
import com.automation.pages.ProductPage;

import helper.ConfigManager;

public class CheckoutTest extends BaseTest{

    Page page;
    LoginPage loginPage;
    ProductPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    PaymentDonePage paymentDonePage;

    String Tshirt = "Pure Cotton Neon Green Tshirt";

    /* 
     * Scenario Checkout Test :
     * 1. Login
     * 2. Filter And Search Your Products
     * 3. Add To Cart
     * 4. Checkout Product
     * 5.
     */
    @BeforeClass
    public void setUp() {
        String url = ConfigManager.getUrl();
        super.setUp(url);
        page = new Page(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        paymentDonePage = new PaymentDonePage(driver);
    }

    @Test
    public void testLoginWithValidCredentials() {
        Assert.assertEquals(page.getHomeTitle(), "AutomationExercise", "Home page title is not as expected");
        page.navigateToLogin();
        Assert.assertEquals(loginPage.getLoginTitle(), "Login to your account", "Login Page title is not as expected");
        loginPage.login("daffa.virdianto@gmail.com", "daffa123");
        Assert.assertEquals(page.getLoginSuccess(), "Daffa Virdianto", "Login success message is not as expected");
    }

    @Test(dependsOnMethods = "testLoginWithValidCredentials")
    public void testCheckoutWithFilter() throws InterruptedException {

        page.navigateToProducts();
        Assert.assertEquals(productsPage.getProductTitle(), "ALL PRODUCTS", "Product Title is not as expected");

        productsPage.clickFilterTShirt();
        Assert.assertEquals(productsPage.getProductTitle(), "MEN - TSHIRTS PRODUCTS", "Filtered product title is not as expected");

        productsPage.viewDetailProduct(Tshirt);
        productDetailPage.setQuantity();
        productDetailPage.viewCart();
        Assert.assertEquals(cartPage.getPageTitle(), "Shopping Cart", "Cart Title is not as expected");
        Assert.assertTrue(cartPage.isProductInCart(Tshirt), "Product name is not match");

        cartPage.goToCheckoutPage();
        Assert.assertEquals(checkoutPage.getPageTitle(), "Checkout", "Checkout Title is not as expected");

        checkoutPage.goToPaymentPage();
        Assert.assertEquals(paymentPage.getPageTitle(), "Payment", "Payment Title is not as expected");

        paymentPage.setPayment();
        paymentPage.sendPayment();
        Assert.assertEquals(paymentDonePage.getPaymentSuccessTitle(), "ORDER PLACED!", "Transaction Success Page is not match" );

        paymentDonePage.downloadInvoice();
        Assert.assertTrue(paymentDonePage.verifyDownloadInvoice(), "Invoice was not downloaded successfully");
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
