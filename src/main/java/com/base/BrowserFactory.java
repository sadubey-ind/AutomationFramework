package com.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Description of your class or code file.
 * 
 * @author Saurabh Dubey
 * @version 1.0
 */

public class BrowserFactory {

	public static WebDriver driver;

	public static WebDriver browser() {
		String browser = getdata("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase(browser)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();

		} else {
			System.out.println("Please pass valid browser prarameter");
		}

		return driver;
	}

	public static Properties getProperties() {
		Properties properties = new Properties(); // Initialize properties object

		try {
			FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties"); // Removed
																											// leading
																											// "/"
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static String getdata(String data) {
		String url = getProperties().getProperty(data);
		return url;
	}

}
