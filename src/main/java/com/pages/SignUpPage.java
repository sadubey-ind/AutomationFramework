package com.pages;

import java.awt.Checkbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SignUpPage extends BaseClass{
	String address1="Vill:Dube\nPs:gopalpur";

	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@name='name']") WebElement ele;
	@FindBy(xpath="(//input[@name='email'])[2]") WebElement ele1;
	@FindBy(xpath="//button[text()='Signup']") WebElement ele2;
	@FindBy(xpath="//input[@id='password']") WebElement pass;
	@FindBy(xpath="//select[@name='days']") WebElement txtday;
	@FindBy(xpath="//select[@name='months']") WebElement txtmon;
	@FindBy(xpath="//select[@name='years']") WebElement txtyer;
	@FindBy(xpath="//input[@id='newsletter']") WebElement chkbox1;
	@FindBy(xpath="//input[@id='optin']") WebElement chkbox2;
	@FindBy(xpath="//input[@id='first_name']") WebElement fname;
	@FindBy(xpath="//input[@id='last_name']") WebElement lname;
	@FindBy(xpath="//input[@id='company']") WebElement cname;
	@FindBy(xpath="//input[@id='address1']") WebElement address;//input[@id='address1'
	@FindBy(xpath="//select[@id='country']") WebElement cou;
	@FindBy(xpath="//input[@id='state']") WebElement state;
	@FindBy(xpath="//input[@id='city']") WebElement city;
	@FindBy(xpath="//input[@id='zipcode']") WebElement zipcode;
	@FindBy(xpath="//input[@id='mobile_number']") WebElement mobile_number;
	@FindBy(xpath = "//button[text()='Create Account']")WebElement btn;
	
	public void signup_usr(String name,String email)
	{
		sendkeys(ele, name);
		sendkeys(ele1, email);
		click(ele2);
	}
	public void moreDetails(String password,String day,String months,String years,String fname1,String lname1,String comp)
	{
		sendkeys(pass, password);
		dropdown(txtday, day);
		dropdown(txtmon, months);
		dropdown(txtyer, years);
		checkbox(chkbox1);
		checkbox(chkbox2);
		sendkeys(fname, fname1);
		sendkeys(lname, lname1);
		sendkeys(cname, comp);
		sendkeys(address, address1);
		dropdown(cou, "India");
		sendkeys(state, "Bihar");
		sendkeys(city, "GPJ");
		sendkeys(zipcode, "351579");
		sendkeys(mobile_number, "9534863415");
		click(btn);
		
		
		
		
	}
	

}
