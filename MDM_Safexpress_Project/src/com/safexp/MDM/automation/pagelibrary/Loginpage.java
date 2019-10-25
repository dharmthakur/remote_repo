package com.safexp.MDM.automation.pagelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class Loginpage {
	
	public void verifyLogin()
	{
		UtilityClass.getWebElement("Loginpage_login_btn").click();
		UtilityClass.getWebElement("Loginpage_usernm_Input").sendKeys("8448828089");
		UtilityClass.getWebElement("Loginpage_password_Input").sendKeys("dharm1180");

	}

}
