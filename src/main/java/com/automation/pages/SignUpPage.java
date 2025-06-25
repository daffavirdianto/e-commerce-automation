package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "uniform-id_gender1")
    public WebElement genderRadioButton;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "first_name")
    public WebElement firstNameInput;

    @FindBy(id = "last_name")
    public WebElement lastNameInput;

    @FindBy(id = "company")
    public WebElement companyInput;

    @FindBy(id = "address1")
    public WebElement addressInput;

    @FindBy(id = "days")
    public WebElement dayDropdown;

    @FindBy(id = "months")
    public WebElement monthDropdown;

    @FindBy(id = "years")
    public WebElement yearDropdown;
    
    @FindBy(id = "country")
    public WebElement countryDropdown;
    
    @FindBy(id = "state")
    public WebElement stateInput;

    @FindBy(id = "city")
    public WebElement cityInput;

    @FindBy(id = "zipcode")
    public WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberInput;

    By signUpTitle = By.xpath("//b[contains(text(), 'Enter Account Information')]");
    By signUpButton = By.xpath("//form[@action='/signup']/button");

    public void selectGender() {
        genderRadioButton.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterCompany(String company) {
        companyInput.sendKeys(company);
    }

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void selectDay(String dayValue) {
        dayDropdown.click();
        dayDropdown.findElement(By.xpath("//select[@id='days']/option[@value='" + dayValue + "']")).click();
    }

    public void selectMonth(String monthValue) {
        monthDropdown.click();
        monthDropdown.findElement(By.xpath("//select[@id='months']/option[@value='" + monthValue + "']")).click();
    }

    public void selectYear(String yearValue) {
        yearDropdown.click();
        yearDropdown.findElement(By.xpath("//select[@id='years']/option[@value='" + yearValue + "']")).click();
    }

    public void selectCountry(String countryValue) {
        countryDropdown.click();
        countryDropdown.findElement(By.xpath("//select[@id='country']/option[@value='" + countryValue + "']")).click();
    }

    public void enterState(String state) {
        stateInput.sendKeys(state);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        zipcodeInput.sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public String getAcountInformationTitle() {
        return driver.findElement(signUpTitle).getText();
    }
}
