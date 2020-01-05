package com.safexp.MDM.automation.baseClass;

import org.apache.log4j.Logger;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class BaseClass {
	
	Logger log=Logger.getLogger(BaseClass.class.getName());
	
	public void launchApp(String s)
	{
		log.info("Application is launching");
		UtilityClass.launchApplication(s);
		//UtilityClass.fn_Click("HomePage_Link");
		log.info("Application launched");
	}
	
	public void closeApp()
	{ 
		log.info("Application is being closed");
		UtilityClass.closeApplication();
		log.info("Application is closed");
	}
	public void clickOnMenu()
	{
		
	    UtilityClass.fn_Click("CreateUserLanding_Menu_BT");
	   
	}
	
	public void clickOnUserManagementMenuOption_sidenavlist()
	{
		clickOnMenu();
	    UtilityClass.clickOnElementByIndexInList("CreateUserLanding_MenuOptions_LIST",1);
	   
	}
	public void clickOnRoleManagementMenuOption_sidenavlist()
	{
		clickOnMenu();
	    UtilityClass.clickOnElementByIndexInList("CreateUserLanding_MenuOptions_LIST",2);
	   
	}
	public void clickOnObjectManagementMenuOption_sidenavlist()
	{
		clickOnMenu();
	    UtilityClass.clickOnElementByIndexInList("CreateUserLanding_MenuOptions_LIST",3);
	   
	}
	public void clickOnContractMenuOption_sidenavlist()
	{
		clickOnMenu();
	    UtilityClass.clickOnElementByIndexInList("CreateUserLanding_MenuOptions_LIST",4);
	   
	}
	public void clickOnMSAMenuOption_sidenavlist()
	{
		clickOnMenu();
	    UtilityClass.clickOnElementByIndexInList("CreateUserLanding_MenuOptions_LIST",5);
	   
	}
	public void clickOnOpportunityMenuOption_sidenavlist()
	{
		clickOnMenu();
	    UtilityClass.clickOnElementByIndexInList("CreateUserLanding_MenuOptions_LIST",6);
	   
	}
	public void clickOnServiceMenuOption_sidenavlist()
	{
		clickOnMenu();
	    UtilityClass.clickOnElementByIndexInList("CreateUserLanding_MenuOptions_LIST",7);
	   
	}
	public void clickOnRatecardMenuOption_sidenavlist()
	{
		clickOnMenu();
	    UtilityClass.clickOnElementByIndexInList("CreateUserLanding_MenuOptions_LIST",8);
	   
	}
	public void clickOnBillingMenuOption_sidenavlist()
	{
		clickOnMenu();
	    UtilityClass.clickOnElementByIndexInList("CreateUserLanding_MenuOptions_LIST",9);
	   
	}
}
