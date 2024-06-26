package com.base;

import java.io.File;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import com.resuource.CommonProperties;

/**
 * Description of your class or code file.
 * 
 * @author Saurabh Dubey
 * @version 1.0
 */

public class BaseClass extends BrowserFactory {
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	public JavascriptExecutor js=
	public static Logger logger;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public String l1;

	@BeforeTest
	public void setUp() {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				"Reports/extent-report.html" + getCurrentDateTimeAsString());
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setReportName("ExtentReports Demo");
		sparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		logger = LogManager.getLogger(getClass());
		BrowserFactory.browser();

		driver.get(getdata("url"));
		extentTest = extentReports.createTest("Automation Framework");
		extentTest.pass(driver.getTitle());
		logger.info(driver.getTitle());

	}

	public static String getCurrentDateTimeAsString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date currentDate = new Date();
		return dateFormat.format(currentDate);
	}
	@AfterMethod
	public void takeScreenshot(ITestResult result)//method for taking the screenshot when failure
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sc=ts.getScreenshotAs(OutputType.FILE);
			String location="./Screenshot/"+result.getName()+getCurrentDateTimeAsString();
			l1=location;
			try {
				FileUtils.copyFile(sc, new File(location+".png"));
				logger.info("Screenshot taken succesfully");
				
				
				
				 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@AfterTest
	public void tearDown() {
		System.out.println(l1);
		extentTest.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(l1+".png").build());
		driver.quit();
		extentReports.flush();
	}

	public void click(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		String txt = ele.getText();
		logger.info(txt);
		extentTest.info("Click on :" + txt);
		ele.click();
	}

	public void sendkeys(WebElement ele, String text) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		String txt = ele.getText();
		logger.info(txt);
		extentTest.info("Click on :" + txt);
		ele.clear();
		ele.sendKeys(text);

	}

	public void radioBtn(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		String txt = ele.getText();
		logger.info(txt);
		extentTest.info("Click on :" + txt);

	}

	public void dropdown(WebElement ele, String text) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		Select sc = new Select(ele);
		sc.selectByVisibleText(text);
//		String txt = ele.getText();
		logger.info("and select by visible text :" + text);
		extentTest.info("select by visible text :" + text);

	}

	public void checkbox(WebElement ele) {
		wait.until(ExpectedConditions.elementSelectionStateToBe(ele, false));
		ele.click();
		String txt = ele.getText();
		logger.info(txt);
		extentTest.info("Clicked on Checkbox");

	}

}
