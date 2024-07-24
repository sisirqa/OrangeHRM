package com.orangehrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseTest {
    protected WebDriver driver;
    protected ExtentTest test;

    @BeforeTest
    public void setupExtentTest() {
        test = ExtentManager.createTest(getClass().getSimpleName());
    }

    @AfterTest
    public void tearDownExtentTest() {
        ExtentManager.flushReports();
    }

    @BeforeMethod
    public void setUp() {
        log.info("Setting up WebDriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    @AfterMethod
    public void tearDown() {
        log.info("Tearing down WebDriver");
        String keepBrowserOpen = System.getProperty("keepBrowserOpen");
        if (driver != null && (keepBrowserOpen == null || !keepBrowserOpen.equals("true"))) {
            driver.quit();
        }
    }
}