package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;

public class Loginpage extends BaseClass
{
	Logger log=Logger.getLogger(Loginpage.class.getName());
	public void verifyLogin(String s1)
	{
		//log.info("clicking on login button");
		//UtilityClass.fn_Click("Loginpage_login_btn");
		UtilityClass.fn_Click("usermanagement_plusicon_bt");
		
		//log.info("providing mobile number in username input field");
		//UtilityClass.fn_Input("Loginpage_usernm_Input", s1);
		//System.out.println("in verifylogin");
		
	}
	

}
