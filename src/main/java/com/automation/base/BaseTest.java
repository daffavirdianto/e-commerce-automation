package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.utils.ConfigReader;

public class BaseTest {

    public WebDriver driver;

    public void setUp() {
        System.out.println("Setting up the test environment...");
        String BASE_URL = ConfigReader.getProperty("base_url");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daffa Virdianto\\web-automation-playground\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
