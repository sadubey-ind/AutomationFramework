package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class HomePage extends BaseClass {
//	private WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//button[@class='btn btn-success' and text()='Test Cases'])[1]")
	WebElement ele;
	@FindBy(xpath = "//a[contains(@href,'login')]")
	WebElement singUpLogin;

	public void click_on_TestCase() {
		click(ele);
		click(singUpLogin);

	}

}
