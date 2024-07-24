package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeaveModule extends BaseTest {

    @Test
    public void testLeaveModule() {
        test = ExtentManager.createTest("Leave Module Test");

        try {
            log.info("Starting Leave Module test");

            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Login
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

            // Wait for the dashboard page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
            log.info("Successfully logged in");
            test.pass("Successfully logged in");

            // Navigate to Leave Module
            WebElement leaveTab = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Leave']")));
            leaveTab.click();
            log.debug("Clicked on Leave tab");
            test.info("Clicked on Leave tab");

            // Wait for Leave List header
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Leave List']")));
                WebElement leaveListHeader = driver.findElement(By.xpath("//h6[text()='Leave List']"));
                assert leaveListHeader.isDisplayed() : "Leave Module navigation failed: Leave List not displayed";
                log.info("Successfully navigated to Leave Module");
                test.pass("Successfully navigated to Leave Module");
            } catch (Exception e) {
                log.error("Failed to navigate to Leave Module: ", e);
                test.fail("Failed to navigate to Leave Module: " + e.getMessage());
            }
        } catch (Exception e) {
            // Handle any other exceptions that might occur during the test
            log.error("Unexpected error during test execution: ", e);
            test.fail("Test failed due to unexpected error: " + e.getMessage());
        }
    }
}
