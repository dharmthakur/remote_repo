package com.safexp.MDM.automation.pagelibrary;


import org.apache.log4j.Logger;
import org.testng.Assert;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;



public class SearchedLandingPage extends BaseClass {
	Logger log=Logger.getLogger(SearchedLandingPage.class.getName());
	
	
	public void verifyPageTitle(String s)
	{
		
		String str=UtilityClass.getTitleOfPage();
		log.info("title of page is :"+str);
		Assert.assertTrue(str.contains(s),"string mismatch");
			
	}

}
