package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    public WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginLink;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountLink;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsLink;

    By homeTitle = By.xpath("//div[@class='col-sm-6']/h1");

    By loginSuccess = By.xpath("//b");

    public void navigateToLogin() {
        loginLink.click();
    }

    public void navigateToLogOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> logoutLink.isDisplayed() && logoutLink.isEnabled());
        logoutLink.click();
    }

    public void navigateToDeleteAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> deleteAccountLink.isDisplayed() && deleteAccountLink.isEnabled());
        deleteAccountLink.click();
    }

    public void navigateToProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> productsLink.isDisplayed() && productsLink.isEnabled());
        productsLink.click();
    }
    
    public String getHomeTitle() {
        return driver.findElement(homeTitle).getText();
    }

    public String getLoginSuccess() {
        return driver.findElement(loginSuccess).getText();
    }
}
