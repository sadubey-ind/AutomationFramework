package com.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * Description of your class or code file.
 * 
 * @author Saurabh Dubey
 * @version 1.0
 */
public class PageDelete extends BaseClass {

	public PageDelete(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver.navigate().to("https://automationexercise.com/login");
	}

	@FindBy(xpath = "(//input[@name='email'])[1]")
	WebElement ele;
	@FindBy(xpath = "//input[@name='password']")
	WebElement ele1;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement ele2;
	@FindBy(xpath = "//a[@href='/delete_account']")
	WebElement ele4;

	public PageDelete login(String email, String pass) {
		sendkeys(ele, email);
		sendkeys(ele1, pass);
		click(ele2);
		logger.info("Loggin Succesfully");
		extentTest.info("Login succesfully");
		assertEquals(" ", false);
		return this;
	}

	public PageDelete deleteAcc() {
		click(ele4);
		logger.info("Account deleted ");
		extentTest.info("account deleted");
		return this;
	}

}
