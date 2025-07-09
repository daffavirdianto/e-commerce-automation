package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "quantity")
    public WebElement inputQuantity;

    @FindBy(css = ".btn.btn-default.cart")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//p/a[@href='/view_cart']")
    public WebElement viewCartBtn;

    public void setQuantity() throws InterruptedException {
        inputQuantity.sendKeys("2");
        addToCartBtn.click();
        Thread.sleep(20);
    }

    public void viewCart() {
        viewCartBtn.click();
    }
}
