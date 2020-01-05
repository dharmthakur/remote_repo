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
		//System.out.println(s);
		
		String s1=UtilityClass.genRandomNumber();
		//System.out.println(s1);
		StringBuilder sb = new StringBuilder(s); 
		sb.append(s1);
		UtilityClass.expectedUserid=sb.toString();
		//System.out.println(UtilityClass.expectedUserid);
		
		UtilityClass.fn_Input("CreateUserLanding_UID_IN",UtilityClass.expectedUserid);
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
		UtilityClass.fn_Click("CreateUserLanding_UBranch_AdvanceSearch");
		UtilityClass.fn_SelectByVisibleText("UserAdvanceSearch_Name","PINCODE");
		UtilityClass.fn_Input("UserAdvanceSearch_popup_searchbox","110");
		UtilityClass.fn_Click("UserAdvanceSearch_popup_searchIcon");
		UtilityClass.fn_SelectByVisibleText("UserAdvanceSearch_popup_selectAfterSearchIconClickked","110037");
		UtilityClass.fn_Click("UserAdvanceSearch_popup_radioAfterselect");
		UtilityClass.fn_Click("UserAdvanceSearch_popup_allocate_BT");
		UtilityClass.fn_Input("CreateUserLanding_UBranch_Search_IN","ABO01");
		//UtilityClass.pressDownArrowKey("CreateUserLanding_UBranch_Search_IN");
		//UtilityClass.pressEnterKey("CreateUserLanding_UBranch_Search_IN");
	}
	
	
	public void enterPrivillageBranch(String s)
	{ 
		UtilityClass.fn_Click("CreateUserLanding_UPrBranch_IN");
		UtilityClass.scrollToElementIntoView("CreateUserLanding_UPrBranch_AdvanceSearch");
		UtilityClass.fn_Click("CreateUserLanding_UPrBranch_AdvanceSearch");
		UtilityClass.fn_SelectByVisibleText("UserAdvanceSearch_PrBranch_Name","AREA");
		UtilityClass.fn_SelectByVisibleText("UserAdvanceSearch_PrBranch_popup_selectAfterSearchIconClickked","ABO01");
		UtilityClass.fn_Click("UserAdvanceSearch_PrBranch_popup_radioAfterselect");
		UtilityClass.fn_Click("UserAdvanceSearch_PrBranch_popup_allocate_BT");
		UtilityClass.fn_Input("CreateUserLanding_UPrBranch_Search_IN","ABO04");
		
	}
	
	
	public void clickOnSave()
	{
		
		UtilityClass.scrollToElementIntoView("CreateUserLanding_SAVE_BT");
		UtilityClass.fn_Click("CreateUserLanding_SAVE_BT");
		

	}
	
	public void checkCreatedUserInList()
	{
		String s=UtilityClass.getdataofWebTable("UsermanagementHome_WebTable");
		System.out.println(s);
		UtilityClass.validateString(s);
	}
	
	public void newUserCreationWithManditoryFields(String id,String name,String email,String mobile,String category)
	{
		enterUserID(id);
		enterUserName(name);
		enterEmailID(email);
		enterContact(mobile);
		enterCategory(category);
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


