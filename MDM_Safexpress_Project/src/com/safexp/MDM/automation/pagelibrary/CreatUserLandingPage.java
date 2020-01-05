package com.safexp.MDM.automation.pagelibrary;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;

public class CreatUserLandingPage {
	Logger log=Logger.getLogger(CreatUserLandingPage.class.getName());
	public void enterUserID(String s)
	{
		System.out.println(s);
		UtilityClass.fn_Input("CreateUserLanding_UID_IN", s);
		log.info("userid entered");
	}
	public void enterUserName(String s)
	{
		UtilityClass.fn_Input("CreateUserLanding_UNM_IN", s);
		log.info("username entered");
	}
	public void enterEmailID(String s)
	{
		UtilityClass.fn_Input("CreateUserLanding_UMAIL_IN", s);
		log.info("user email id entered");
	}
	public void enterContact(String s)
	{
		UtilityClass.fn_Input("CreateUserLanding_UMOBILE_IN", s);
		log.info("user contact entered");
	}
	public void enterCategory(String s)
	{
		UtilityClass.fn_SelectByVisibleText("CreateUserLanding_UCATEGORY_IN", s);
		log.info("category selected");
	}
	public void enterRole(String s)
	{
		
		UtilityClass.fn_Click("CreateUserLanding_URole_IN");
		UtilityClass.fn_Input("CreateUserLanding_URole_Search_IN", s);
	}
	public void enterDefaultBranch(String branch)
	{
		UtilityClass.fn_Click("CreateUserLanding_UBranch_IN");
		UtilityClass.fn_Input("CreateUserLanding_UBranch_Search_IN",branch);
	}
	public void enterPrivillageBranch(String s)
	{ 
		UtilityClass.fn_Click("CreateUserLanding_UPrBranch_IN");
		UtilityClass.fn_Input("CreateUserLanding_UPrBranch_Search_IN", s);
		
	}
	
	public void clickOnSave()
	{
		//UtilityClass.fn_Click("CreateUserLanding_SAVE_BT");
		UtilityClass.scrollToElementIntoView("CreateUserLanding_SAVE_BT");
		log.info("save button clicked");
		
	}
	
	public void newUserCreationWithManditoryFields(String id,String name,String email,String mobile,String category,String branch,String privil_branch,String role)
	{
		log.info("entering all mandatory fields");
		enterUserID(id);
		enterUserName(name);
		enterEmailID(email);
		enterContact(mobile);
		enterDefaultBranch(branch);
		enterPrivillageBranch(privil_branch);
		enterRole(role);
		clickOnSave();
		log.info("new user created with mandatory fields");
	}
	
	public void searchDefaultBranch(String branch)
	{
		log.info("searching default branch");
		enterDefaultBranch(branch);
		clickOnSave();
	}
		
	public void searchPrivillageBranch(String branch)
	{
		log.info("searching privillage branch");
		enterPrivillageBranch(branch);
		clickOnSave();
	}
	
	
}


