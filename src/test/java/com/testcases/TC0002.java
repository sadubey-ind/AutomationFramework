package com.testcases;

//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC0002 {

    private WebDriver driver;
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    @BeforeSuite
    public void setUp() {
        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        
        // Initialize ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Test
    public void sampleTest() {
        extentTest = extentReports.createTest("Sample Test");
        driver.get("https://www.example.com");
        extentTest.log(Status.INFO, "Navigated to example.com");
        // Perform test steps
        extentTest.log(Status.PASS, "Test Passed");
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
