package com.safexp.MDM.automation.testcases.Usermanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.managerClasses.HybridFrameworkDriver;
//@Listeners(com.safexp.MDM.automation.managerClasses.TestListener.class)
public class UsercreationTest {
	@BeforeTest
	public void driverInitialisation()
	{
		UtilityClass.Init();
    }

	@Test(dataProvider="executableTestID_provider")
	public void hybridTestAutomation(String s1, String s2,String s3)
	{
		UtilityClass.logger=UtilityClass.extent.createTest(s2);
		System.out.println("hello");
		System.out.println(s3);
		
	   	HybridFrameworkDriver.hybridTestAutomation(s1, s2,s3,"TestData/UserManagement_createUser.xls","ScriptDriverSheet/UserManagement/createUser.xls");
	   	UtilityClass.extent.flush();
     }
	      	
@DataProvider
	public Object[][] executableTestID_provider()
	{
	int n;
    Object[][] obj=null;
	Connection conn;
	Recordset record;
	
	Fillo f=new Fillo();
	try {
	conn=f.getConnection("ScriptDriverSheet/UserManagement/createUser.xls");
	
	record=conn.executeQuery("select TestCaseID,TestCaseName,SubmoduleName from DriverSheet where ExecutionMode='y'");
	
	n=record.getCount();
	obj=new Object[n][3];
	for(int i=0;i<n;i++)
	{
		record.next();
		obj[i][0]=record.getField("TestCaseID");
		obj[i][1]=record.getField("TestCaseName");
		obj[i][2]=record.getField("SubmoduleName");
		
	}
	}catch(Exception e) {}
	return obj;
			
	}


@AfterMethod
public void closeOpenWindows()
{
	//UtilityClass.closeAllWindow();
}

}
