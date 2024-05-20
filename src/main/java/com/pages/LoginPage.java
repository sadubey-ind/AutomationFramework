package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		driver.navigate().to("https://automationexercise.com/login");
	}
	@FindBy(xpath="(//input[@name='email'])[1]") WebElement ele;
	@FindBy(xpath="//input[@name='password']") WebElement ele1;
	@FindBy(xpath="//button[text()='Login']") WebElement ele2;
	
	public LoginPage login(String email,String pass)
	{
		sendkeys(ele, email);
		sendkeys(ele1, pass);
		click(ele2);
		logger.info("Loggin Succesfully");
		extentTest.info("Login succesfully");
		return this;
	}
	

}
