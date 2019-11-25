package com.safexp.MDM.automation.pagelibrary;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.safexp.MDM.automation.Utility.UtilityClass;

public class CreatUserLandingPage {
	
	public void enterUserID(String s)
	{
		System.out.println(s);
		UtilityClass.fn_Input("CreateUserLanding_UID_IN", s);
	}
	public void enterUserName(String s)
	{
		UtilityClass.fn_Input("CreateUserLanding_UNM_IN", s);
	}
	public void enterEmailID(String s)
	{
		UtilityClass.fn_Input("CreateUserLanding_UMAIL_IN", s);
	}
	public void enterContact(String s)
	{
		UtilityClass.fn_Input("CreateUserLanding_UMOBILE_IN", s);
	}
	public void enterCategory(String s)
	{
		UtilityClass.fn_SelectByVisibleText("CreateUserLanding_UCATEGORY_IN", s);
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
		

	}
	
	public void newUserCreationWithManditoryFields(String id,String name,String email,String mobile,String category,String branch,String privil_branch,String role)
	{
		enterUserID(id);
		enterUserName(name);
		enterEmailID(email);
		enterContact(mobile);
		enterDefaultBranch(branch);
		enterPrivillageBranch(privil_branch);
		enterRole(role);
		clickOnSave();
	}
	
	public void searchDefaultBranch(String branch)
	{
		enterDefaultBranch(branch);
		clickOnSave();
	}
		
	public void searchPrivillageBranch(String branch)
	{
		enterPrivillageBranch(branch);
		clickOnSave();
	}
	
	
}


