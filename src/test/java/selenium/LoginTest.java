package selenium;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.Page;

import helper.ConfigManager;

public class LoginTest extends BaseTest {

    Page page;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        String url = ConfigManager.getUrl();
        super.setUp(url);
        
        page = new Page(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginWithValidCredentials() {
        Assert.assertEquals(page.getHomeTitle(), "AutomationExercise", "Home page title is not as expected");
        page.navigateToLogin();
        Assert.assertEquals(loginPage.getLoginTitle(), "Login to your account", "Login Page title is not as expected");
        loginPage.login("daffa.virdianto@gmail.com", "daffa123");
        Assert.assertEquals(page.getLoginSuccess(), "Daffa Virdianto", "Login success message is not as expected");
        page.navigateToLogOut();
    }

    @Test(dataProvider = "invalidCredentialData")
    public void testLoginWithInvalidCredentials(String email, String password, String errorMessage) {
        Assert.assertEquals(page.getHomeTitle(), "AutomationExercise", "Home page title is not as expected");
        page.navigateToLogin();
        Assert.assertEquals(loginPage.getLoginTitle(), "Login to your account", "Login Page title is not as expected");
        loginPage.login(email, password);

        Assert.assertEquals(loginPage.getErrorMessage(email), errorMessage, "Error message is not as expected");
    }

    @DataProvider(name = "invalidCredentialData")
    public Object[][] invalidCredentialData() {
        return new Object[][] {
            {"daffa.virdianto1@gmail.com", "daffa123", "Your email or password is incorrect!"},
            {"daffa.virdianto@gmail.com", "daffa1234", "Your email or password is incorrect!"},
            {"daffa", "daffa", "Please include an \u0027@\u0027 in the email address. \u0027daffa\u0027 is missing an \u0027@\u0027."},
            {"", "", "Please fill out this field."}
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
