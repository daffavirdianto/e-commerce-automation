package stepDefinitions;

import org.testng.Assert;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.LoginPage;
import com.automation.pages.Page;
import com.automation.pages.PaymentDonePage;
import com.automation.pages.PaymentPage;
import com.automation.pages.ProductDetailPage;
import com.automation.pages.ProductPage;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseTest{

    Page page;
    LoginPage loginPage;
    ProductPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    PaymentDonePage paymentDonePage;

    @Given("User landing to logged ecommerce")
    public void user_landing_to_logged_ecommerce() {
        driver = Hooks.initializeDriver();
        page = new Page(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        paymentDonePage = new PaymentDonePage(driver);

        page.navigateToLogin();
    }

    @When("User input email {string} and password {string}")
    public void userInputEmailAndPassword(String email, String password) {
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        loginPage.login(email, password);
    }
    
    @Then("User redirect to homepage")
    public void userRedirectToHomepage() {
        Assert.assertEquals(page.getLoginSuccess(), "Daffa Virdianto", "Login success message is not as expected");
    }

    @When("Customer view a product {string}")
    public void customer_view_a_product(String productName) {
        productsPage.viewDetailProduct(productName);
    }
    
    @And("Customer add the quantity {string} of products")
    public void customer_add_the_quantity_of_products(String quantity) throws InterruptedException {
        productDetailPage.setQuantity(quantity);
    }
    
    @Then("Verify Product successfully added {string} on cart page")
    public void verify_product_successfully_added_on_cart_page(String productName) {
        productDetailPage.viewCart();
        Assert.assertTrue(cartPage.isProductInCart(productName), "Product name is not match");
    }

    @When("Customer redirect to checkout page")
    public void customerGoToCheckoutPage(){
        cartPage.goToCheckoutPage();
        Assert.assertEquals(checkoutPage.getPageTitle(), "Checkout", "Checkout Title is not as expected");
    }

    @When("Customer redirect to payment page")
    public void customerGoToPaymentPage() {
        checkoutPage.goToPaymentPage();
        Assert.assertEquals(paymentPage.getPageTitle(), "Payment", "Payment Title is not as expected");
    }

    @And("Customer set payment details")
    public void customerSetPayment() {
        paymentPage.setPayment();
    }

    @And("Customer send payment")
    public void customerSendPayment() {
        paymentPage.sendPayment();
    }

    @Then("Verify successfully payment on payment page")
    public void verify_product_successfully_added_on_cart_page() {
        Assert.assertEquals(paymentDonePage.getPaymentSuccessTitle(), "ORDER PLACED!", "Transaction Success Page is not match" );
    }
}