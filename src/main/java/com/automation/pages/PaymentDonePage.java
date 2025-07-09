package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDonePage {

    WebDriver driver;

    public PaymentDonePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement paymentSuccessTitle;

    @FindBy(css = ".check_out")
    public WebElement downloadInvoiceBtn;

    public String getPaymentSuccessTitle() {
        return paymentSuccessTitle.getText();
    }

    public void downloadInvoice() {
        downloadInvoiceBtn.click();
    }

    public Boolean verifyDownloadInvoice() throws InterruptedException {
        String downloadPath = System.getProperty("user.home") + "/Downloads/invoice.txt";
        File invoiceFile = new File(downloadPath);
        int waitTime = 0;
        while (waitTime < 10) {
            if (invoiceFile.exists()) {
                return true;
            }
            Thread.sleep(1000);
            waitTime++;
        }

        return false;
    }

}
