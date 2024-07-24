package com.orangehrm;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            log.info("Initializing ExtentReports");
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static ExtentTest createTest(String name) {
        log.info("Creating ExtentTest: {}", name);
        test = getInstance().createTest(name);
        return test;
    }

    public static ExtentTest getTest() {
        if (test == null) {
            log.warn("ExtentTest is null. Make sure to call createTest() first.");
        }
        return test;
    }

    public static void flushReports() {
        if (extent != null) {
            log.info("Flushing ExtentReports");
            extent.flush();
        } else {
            log.warn("ExtentReports instance is null. Nothing to flush.");
        }
    }
}