package com.safexp.MDM.automation.testcases;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.managerClasses.HybridFrameworkDriver;
import com.safexp.MDM.automation.managerClasses.ReadExcelData;
import com.safexp.MDM.automation.pagelibrary.Loginpage;


public class TestngDemo {
	
	
	
	@BeforeTest
	public void driverInitialisation()
	{
		UtilityClass.Init();
    }

	@Test(dataProvider="executableTestID_provider")
	public void hybridTestAutomation(String s1, String s2,String submodule)
	{
		UtilityClass.logger=UtilityClass.extent.createTest(s2);
	   	HybridFrameworkDriver.hybridTestAutomation(s1, s2,submodule,"TestData/testdata.xls","TestData/ModuleLogin.xls");
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
	conn=f.getConnection("TestData/ModuleLogin.xls");
	
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
	UtilityClass.closeAllWindow();
}
}