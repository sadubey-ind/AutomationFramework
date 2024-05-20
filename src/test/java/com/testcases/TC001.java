package com.testcases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.SignUpPage;

public class TC001 extends BaseClass {
	private String title = "AutomationExercise";

	@Test
	public void loginTest() {
		System.out.println(driver.getTitle());
		HomePage hp = new HomePage(driver);
		logger.info(driver.getTitle());
		extentTest.info("Click on EMEA");
		hp.click_on_TestCase();
		SignUpPage sp = new SignUpPage(driver);
		sp.signup_usr("sdubey", "sdubey@demo.com");
		sp.moreDetails("Staing@123", "31", "July", "2001","sd","cs","srd");
	}

}
