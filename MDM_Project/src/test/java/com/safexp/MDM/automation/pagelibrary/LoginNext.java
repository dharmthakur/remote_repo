package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;

public class LoginNext extends BaseClass 
{
Logger log=Logger.getLogger(LoginNext.class.getName());
	public void enterPassword(String s2) 
	{
		log.info("providing password in the password field");
		UtilityClass.fn_Input("Loginpage_password_Input", s2);
	}
}
