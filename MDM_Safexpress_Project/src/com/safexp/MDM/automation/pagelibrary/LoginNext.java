package com.safexp.MDM.automation.pagelibrary;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class LoginNext {

	public void enterPassword(String s2) {
		UtilityClass.getWebElement("Loginpage_password_Input").sendKeys(s2);
	}
}
