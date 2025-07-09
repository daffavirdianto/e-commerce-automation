package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='name_on_card']")
    public WebElement inputCardName;

    @FindBy(xpath = "//input[@name='card_number']")
    public WebElement inputCardNumber;

    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement inputCVC;

    @FindBy(xpath = "//input[@name='expiry_month']")
    public WebElement inputExpiryMonth;

    @FindBy(xpath = "//input[@name='expiry_year']")
    public WebElement inputExpiryYear;

    @FindBy(id = "submit")
    public WebElement payBtn;

    @FindBy(xpath = "//li[@class='active']")
    public WebElement pageTitle;

    public void setPayment() {
        inputCardName.sendKeys("MBank");
        inputCardNumber.sendKeys("54321");
        inputCVC.sendKeys("212");
        inputExpiryMonth.sendKeys("12");
        inputExpiryYear.sendKeys("2025");
    }

    public void sendPayment() {
        payBtn.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

}
