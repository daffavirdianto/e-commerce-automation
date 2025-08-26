package com.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h4[@class='panel-title']/a[@href='#Men']")
    public WebElement menBtn;

    @FindBy(xpath = "//a[contains(text(),'Tshirts')]")
    public WebElement tshirtLink;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement productTitle;

    By listOfProducts = By.xpath("//div[@class='features_items']/div[@class='col-sm-4']");
    By titleProduct = By.cssSelector(".productinfo.text-center > p");
    By viewProductBtn = By.cssSelector(".choose > ul > li > a");

    public void clickFilterTShirt() {
        menBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(tshirtLink));
        tshirtLink.click();
    }

    public int getProductIndexByName(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOfProducts));

        List<WebElement> products = driver.findElements(listOfProducts);
        for (int i = 0; i < products.size(); i++) {
            WebElement nameElement = products.get(i).findElement(titleProduct);
            System.out.println("Searching for product: " + nameElement.getText());
            if (nameElement.getText().equals(productName)) {
                System.out.println("Product '" + productName + "' found at index: " + i);
                return i;
            }
        }
        System.out.println("Product '" + productName + "' not found.");
        return -1;
    }

    public void viewDetailProduct(String productName) {
        List<WebElement> addToCartButtons = driver.findElements(viewProductBtn);
        int productIndex = getProductIndexByName(productName);
        addToCartButtons.get(productIndex).click();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}
