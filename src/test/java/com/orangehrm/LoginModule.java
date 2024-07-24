package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginModule extends BaseTest {

    @Test
    public void testLogin() {
        ExtentTest test = ExtentManager.createTest("Login Test");
        log.info("Starting Login test");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.sendKeys("Admin");
        log.debug("Entered username");
        test.info("Entered username");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        log.debug("Entered password");
        test.info("Entered password");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        log.debug("Clicked login button");
        test.info("Clicked login button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        WebElement dashboardHeader = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        assert dashboardHeader.isDisplayed() : "Login failed: Dashboard not displayed";
        log.info("Successfully logged in and verified dashboard");
        test.pass("Successfully logged in and verified dashboard");
    }

    @Test
    public void testInvalidUsername() {
        ExtentTest test = ExtentManager.createTest("Invalid Username Test");
        log.info("Starting Invalid Username test");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.sendKeys("InvalidUser");
        log.debug("Entered invalid username");
        test.info("Entered invalid username");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        log.debug("Entered password");
        test.info("Entered password");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        log.debug("Clicked login button");
        test.info("Clicked login button");

        WebElement errorMessage = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
        assert errorMessage.isDisplayed() : "Error message not displayed for invalid username";
        log.info("Verified error message for invalid username");
        test.pass("Verified error message for invalid username");
    }
}