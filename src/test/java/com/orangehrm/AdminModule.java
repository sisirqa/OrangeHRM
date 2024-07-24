package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminModule extends BaseTest {

    @Test
    public void testAdminModule() {
        log.info("Starting Admin Module test");

        // Login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.sendKeys("Admin");
        log.debug("Entered username");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        log.debug("Entered password");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        log.debug("Clicked login button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        log.info("Successfully logged in");

        // Navigate to Admin Module
        WebElement adminTab = driver.findElement(By.xpath("//span[text()='Admin']"));
        adminTab.click();
        log.debug("Clicked on Admin tab");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='User Management']")));

        WebElement userManagementHeader = driver.findElement(By.xpath("//h6[text()='User Management']"));
        assert userManagementHeader.isDisplayed() : "Admin Module navigation failed: User Management not displayed";
        log.info("Successfully navigated to Admin Module");
    }
}