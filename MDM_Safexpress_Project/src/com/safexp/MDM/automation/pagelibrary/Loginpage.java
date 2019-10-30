package com.safexp.MDM.automation.pagelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;

public class Loginpage extends BaseClass{
	
	public void verifyLogin(String s1)
	{
		UtilityClass.getWebElement("Loginpage_login_btn").click();
		UtilityClass.getWebElement("Loginpage_usernm_Input").sendKeys(s1);
		//
		System.out.println("in verifylogin");
		//System.out.println(s1);
		//System.out.println(s2);

	}
	
	public void launchApp()
	{try {
		UtilityClass.launchApplication();
	}catch(Exception e) {
		UtilityClass.launchApplication();
	}
		//System.out.println("closing app");
	}

}
