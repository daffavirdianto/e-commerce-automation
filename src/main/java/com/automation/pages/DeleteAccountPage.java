package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {

    public WebDriver driver;

    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    By deleteMessage = By.xpath("//b[contains(text(), 'Account Deleted!')]");

    public String getDeleteMessage() {
        return driver.findElement(deleteMessage).getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
