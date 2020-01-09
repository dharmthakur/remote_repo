package com.safexp.MDM.automation.testcases.Usermanagement;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.base.Verify;
import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.Utility.ZipUtils;
import com.safexp.MDM.automation.managerClasses.HybridFrameworkDriver;
//@Listeners(com.safexp.MDM.automation.managerClasses.TestListener.class)
public class UsercreationTest {
	String drvrsheet=null;
	
	String datasheet=null;
	
	@BeforeTest
	
	public void OR_Log_Extent_Initialisation()
	{
		UtilityClass.Init();
		UtilityClass.deleteFolder(new File(System.getProperty("user.dir")+"/Report"));
		//UtilityClass.launchUrl("FF","http://internal-a856c3eb127ab11ea9bac0a3257c4306-1690014006.ap-south-1.elb.amazonaws.com");
    }
	
	//@BeforeClass
//	@Parameters({"browser","url"})
	/*public void driverInitialisation(String browser,String url)
	{System.out.println(browser);
		UtilityClass.launchUrl("CH","http://internal-a856c3eb127ab11ea9bac0a3257c4306-1690014006.ap-south-1.elb.amazonaws.com");
    }*/
	//@BeforeClass
	public void driverInitialisation()
	{//System.out.println(browser);
		UtilityClass.launchUrl("FF","http://internal-a856c3eb127ab11ea9bac0a3257c4306-1690014006.ap-south-1.elb.amazonaws.com");
    }
	@BeforeMethod
	public void appLaunch() {UtilityClass.launchUrl("CH","http://internal-a856c3eb127ab11ea9bac0a3257c4306-1690014006.ap-south-1.elb.amazonaws.com");}
	@Test(dataProvider="executableTestID_provider")
	public void hybridTestAutomation(String s1, String s2,String s3)
	{
	
		UtilityClass.logger=UtilityClass.extent.createTest(s2);
		System.out.println("hello");
		System.out.println(s3);
		
		//datasheet=System.getProperty("testdatasheet");
	//	System.out.println(datasheet);
	  
		HybridFrameworkDriver.hybridTestAutomation(s1, s2,s3,"TestData/UserManagement_createUser.xls","ScriptDriverSheet/UserManagement/createUser.xls");
	   	//HybridFrameworkDriver.hybridTestAutomation(s1, s2,s3,datasheet,drvrsheet);
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
		//drvrsheet=System.getProperty("Scriptdriversheet");
		//System.out.println(drvrsheet);
	conn=f.getConnection("ScriptDriverSheet/UserManagement/createUser.xls");
	//conn=f.getConnection(drvrsheet);
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


@AfterClass
public void closeOpenWindows1()
{
	System.out.println("after class");
	//UtilityClass.closeAllWindow();
}
@AfterTest
public void closeOpenWindows()
{
	System.out.println("after test");
	//UtilityClass.driver.close();
    //UtilityClass.closeAllWindow();
	try {
		ZipUtils.zipReportFile();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@AfterMethod
public void closeOpenWindow()
{
	System.out.println("after method");
	UtilityClass.driver.close();
    //UtilityClass.closeAllWindow();
}

}
