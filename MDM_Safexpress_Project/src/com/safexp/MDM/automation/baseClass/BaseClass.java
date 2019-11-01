package com.safexp.MDM.automation.baseClass;

import org.apache.log4j.Logger;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class BaseClass {
	
	Logger log=Logger.getLogger(BaseClass.class.getName());
	
	public void launchApp()
	{
		log.info("Application is launching");
		UtilityClass.launchApplication();
		log.info("Application launched");
	}
	
	public void closeApp()
	{ 
		log.info("Application is being closed");
		UtilityClass.closeApplication();
		log.info("Application is closed");
	}

}
