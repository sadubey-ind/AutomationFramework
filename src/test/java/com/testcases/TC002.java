package com.testcases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

public class TC002 extends BaseClass{
	@Test
	public void loginTest()
	{
		LoginPage lp=new LoginPage(driver);
		lp.login("sdubey@demo.com", "Staing@123");
	}

}
