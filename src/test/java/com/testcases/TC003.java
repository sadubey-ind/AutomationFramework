package com.testcases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.PageDelete;

public class TC003 extends BaseClass{
	@Test
	public void deleteTest()
	{
		PageDelete pd=new PageDelete(driver);
		pd.login("sdubey@demo.com", "Staing@123").deleteAcc();
		
		
	}

}
