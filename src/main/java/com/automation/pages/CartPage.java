package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-default.check_out")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//li[@class='active']")
    public WebElement pageTitle;

    By listOfProducts = By.xpath("//tbody/tr");

    public void goToCheckoutPage() {
        checkoutBtn.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public boolean isProductInCart(String productName) {
        for (WebElement row : driver.findElements(listOfProducts)) {
            if (row.getText().contains(productName)) {
                System.out.println("Product is in the cart");
                return true;
            }
        }
        return false;
    }

}
