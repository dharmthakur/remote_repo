package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;

public class Usermanagement_Home extends BaseClass {
	Logger log=Logger.getLogger(Usermanagement_Home.class.getName());
	public void clickOnPlusIcon()
	{   
		UtilityClass.fn_Click("UsermanagementHomeCreateUser_PlusIcon_BT");
		log.info("clicked on PlusIcon");
	}
	

}
