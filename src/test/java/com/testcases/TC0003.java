package com.testcases;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0003 {

    private WebDriver driver;
    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private Logger logger;

    @BeforeSuite
    public void setUp() {
        // Initialize WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Initialize ExtentReports using ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("ExtentReports Demo");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        // Initialize Logger
        logger = LogManager.getLogger(TC0003.class);

        // Register ExtentAppender
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.getConfiguration().getLoggerConfig(LogManager.ROOT_LOGGER_NAME)
                .addAppender(context.getConfiguration().getAppender("ExtentAppender"), Level.INFO, null);
    }

    @Test
    public void sampleTest() {
        extentTest = extentReports.createTest("Sample Test");
        driver.get("https://www.example.com");
        extentTest.pass("Navigated to example.com");

        // Log using logger
        logger.info("Logger");

        // Perform test steps
        extentTest.pass("Test Passed");
    }

    @AfterSuite
    public void tearDown() {
        // Close WebDriver
        if (driver != null) {
            driver.quit();
        }
        // Flush ExtentReports
        extentReports.flush();
    }
}
