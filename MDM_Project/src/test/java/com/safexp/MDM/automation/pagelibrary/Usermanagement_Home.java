package com.safexp.MDM.automation.pagelibrary;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;

public class Usermanagement_Home extends BaseClass {
	
	public void clickOnPlusIcon()
	{
		UtilityClass.fn_Click("UsermanagementHomeCreateUser_PlusIcon_BT");
	}
	
	public void verifyForUserCreation(String expectedVal)
	{   String actual=UtilityClass.getdataofWebTable("UsermanagementHome_WebTable");
		UtilityClass.validateString(actual);
	}

}
