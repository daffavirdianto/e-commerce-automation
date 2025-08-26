package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@action='/login']/input[@name='email']")
    public WebElement emailInputLogin;

    @FindBy(xpath = "//form[@action='/login']/input[@name='password']")
    public WebElement passwordInputLogin;

    @FindBy(xpath = "//form[@action='/login']/button")
    public WebElement loginButton;

    @FindBy(xpath = "//form[@action='/signup']/input[@name='name']")
    public WebElement nameInputSignUp;

    @FindBy(xpath = "//form[@action='/signup']/input[@name='email']")
    public WebElement emailInputSignUp;

    @FindBy(xpath = "//form[@action='/signup']/button")
    public WebElement signUpButton;

    By loginTitle = By.xpath("//div[@class='login-form']/h2");
    By signUpTitle = By.xpath("//div[@class='signup-form']/h2");
    By errorMessage = By.xpath("//form[@action='/login']/p");

    public void login(String email, String password) {
        emailInputLogin.sendKeys(email == null ? "" : email);
        passwordInputLogin.sendKeys(password == null ? "" : password);
        loginButton.click();
    }

    public void validSignUp(String name, String email) {
        nameInputSignUp.sendKeys(name);
        emailInputSignUp.sendKeys(email);
        signUpButton.click();
    }

    public String getLoginTitle() {
        return driver.findElement(loginTitle).getText();
    }

    public String getSignUpTitle() {
        return driver.findElement(signUpTitle).getText();
    }

    public String getErrorMessage(String email) {
        String actualError;

        if (!isEmailValid(email)) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            actualError = (String) js.executeScript("return arguments[0].validationMessage;", emailInputLogin);
        } else {
            actualError = driver.findElement(errorMessage).getText();
        }

        return actualError;
    }

    public boolean isEmailValid(String email) {
        return email.contains("@") && !email.trim().isEmpty();
    }
}
