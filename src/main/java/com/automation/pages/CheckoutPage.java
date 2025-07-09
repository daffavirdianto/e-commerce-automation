package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='active']")
    public WebElement pageTitle;

    @FindBy(xpath = "//a[@href='/payment']")
    public WebElement paymentBtn;

    public void goToPaymentPage() {
        paymentBtn.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}
