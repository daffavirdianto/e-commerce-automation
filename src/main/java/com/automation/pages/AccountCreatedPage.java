package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {

    public WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    By successMessage = By.xpath("//b[contains(text(), 'Account Created!')]");

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
