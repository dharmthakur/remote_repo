package com.safexpress.MDM.API_Automation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;
import com.safexpress.MDM.API_Automation.managerClass.APIFrameworkDriver;


public class APITestUsermanagement {
	
	Logger log=Logger.getLogger(APITestUsermanagement.class.getName());
	@BeforeTest
	public void Init() 
	{log.info("initialising log4j");
		 UtilityClassForAPI.initLogReport();//.Initialise_RequestObject("https://restcountries.eu/rest/v2");
		 UtilityClassForAPI.intitExtentReport();
	}
	
	@Test(dataProvider="apidataprovider")
	public void hybridTestAutomation(String testid, String testname,String module,String submodule)
	{
		UtilityClassForAPI.logger=UtilityClassForAPI.extent.createTest(testname);
		//System.out.println(s3);	
	   	APIFrameworkDriver.automateAPITestcase(testid,testname,module,submodule,"testdata/APITestData.xls","drivesheet/UserManagement_Module/APITestCaseTable1.xls");
	   	UtilityClassForAPI.extent.flush();
     }
	      	
@DataProvider(name="apidataprovider")
	public Object[][] executableTestID_provider()
	{
	int n;
    Object[][] obj=null;
	Connection conn;
	Recordset record;
	
	Fillo f=new Fillo();
	try {
	conn=f.getConnection("drivesheet/UserManagement_Module/APITestCaseTable1.xls");
	
	record=conn.executeQuery("select TestCaseID,TestCaseName,ModuleName,SubmoduleName from driver where ExecutionMode='y'");
	
	n=record.getCount();
	obj=new Object[n][4];
	for(int i=0;i<n;i++)
	{
		record.next();
		obj[i][0]=record.getField("TestCaseID");
		obj[i][1]=record.getField("TestCaseName");
		obj[i][2]=record.getField("ModuleName");
		obj[i][3]=record.getField("SubmoduleName");
				
	}
	}catch(Exception e) {}
	return obj;
			
	}


}
