package com.safexp.MDM.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;




public class ExtentReportDemo 
{
	ExtentReports report=null;
	ExtentTest test=null;
	WebDriver driver=null;
	
	@Test(dataProvider="xyz")
	public void m1(String s1,String s2)
	{System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	driver=new ChromeDriver();

	driver.get("https://www.google.com");
		report=new ExtentReports("C:\\Users\\80127\\git\\remote_repo\\MDM_Safexpress_Project\\Report\\report.html");
		test=report.startTest("m1 started");
		test.log(LogStatus.INFO,"testing report");
		test.log(LogStatus.INFO,"testted");
		System.out.println(System.getProperty("user.dir"));
		String s=driver.getTitle();
		//Assert.assertTrue(s.contains("google"));
		
	}
	
	@DataProvider
	public Object[][] xyz(){
		Object[][] obj=new Object[2][2];
		obj[0][0]="aman";
		obj[0][1]="daksh";
		obj[1][0]="aman";
		obj[1][1]="daksh";
		
		return obj;
	}
	
	@AfterTest
	public void tearDown() {
		report.endTest(test);
		report.flush();
		driver.get("C:\\Users\\80127\\git\\remote_repo\\MDM_Safexpress_Project\\Report\\report.html");
	}
}
