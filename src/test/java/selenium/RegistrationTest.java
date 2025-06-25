package selenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.AccountCreatedPage;
import com.automation.pages.DeleteAccountPage;
import com.automation.pages.LoginPage;
import com.automation.pages.Page;
import com.automation.pages.SignUpPage;

public class RegistrationTest extends BaseTest{

    Page page;
    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountCreatedPage accountCreatedPage;
    DeleteAccountPage deleteAccountPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        page = new Page(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);
    }

    @Test
    public void testValidRegistration() throws InterruptedException {

        Assert.assertEquals(page.getHomeTitle(), "AutomationExercise", "Home page title is not as expected");
        page.navigateToLogin();

        Assert.assertEquals(loginPage.getSignUpTitle(), "New User Signup!", "Login Page title is not as expected");
        loginPage.validSignUp("Daffa Virdianto", "daffa.virdianto1@gmail.com");

        Assert.assertEquals(signUpPage.getAcountInformationTitle(), "ENTER ACCOUNT INFORMATION", "SignUp Page title is not as expected");
        signUpPage.selectGender();
        signUpPage.enterPassword("daffa123");
        signUpPage.enterFirstName("Daffa");
        signUpPage.enterLastName("Virdianto");
        signUpPage.enterCompany("Playground");
        signUpPage.enterAddress("Jl. Raya No. 123");
        signUpPage.selectDay("10");
        signUpPage.selectMonth("9");
        signUpPage.selectYear("1999");
        signUpPage.selectCountry("Singapore");
        signUpPage.enterState("Jakarta");
        signUpPage.enterCity("Jakarta");
        signUpPage.enterZipcode("12345");
        signUpPage.enterMobileNumber("08123456789");
        signUpPage.clickSignUpButton();

        Assert.assertEquals(accountCreatedPage.getSuccessMessage(), "ACCOUNT CREATED!", "Success message does not match expected value.");
        accountCreatedPage.clickContinueButton();
    }

    @Test(dependsOnMethods = "testValidRegistration")
    public void testDeleteAccount() throws InterruptedException {
        page.navigateToDeleteAccount();
        Assert.assertEquals(deleteAccountPage.getDeleteMessage(), "ACCOUNT DELETED!", "Delete message does not match expected value.");
        deleteAccountPage.clickContinueButton();
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}