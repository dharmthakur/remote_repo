package com.safexp.MDM.automation.pagelibrary;

import org.apache.log4j.Logger;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.baseClass.BaseClass;

public class GoogleSearchPage extends BaseClass{
	Logger log=Logger.getLogger(GoogleSearchPage.class.getName());

	public void searchText(String s)
	{
		UtilityClass.fn_Input("GoogleSearch_searchfield_In", s);
		log.info("searchText is :"+s);
		UtilityClass.fn_Click("GoogleSearch_search_bt");
		log.info("search button is clicked");
	}
	
}
