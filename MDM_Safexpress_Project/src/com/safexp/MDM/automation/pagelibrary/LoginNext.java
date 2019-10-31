package com.safexp.MDM.automation.pagelibrary;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;

public class LoginNext extends BaseClass {

	public void enterPassword(String s2) {
		UtilityClass.getWebElement("Loginpage_password_Input").sendKeys(s2);
	}
}
