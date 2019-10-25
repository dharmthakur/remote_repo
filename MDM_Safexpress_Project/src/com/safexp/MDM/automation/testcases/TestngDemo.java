package com.safexp.MDM.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.safexp.MDM.automation.Utility.UtilityClass;
import com.safexp.MDM.automation.pagelibrary.Loginpage;

public class TestngDemo {
	
	@BeforeTest
	public void driverInitialisation()
	{
		UtilityClass.Init();
	}
	
	@BeforeMethod
	public void launchApp()
	{
		UtilityClass.launchApplication("http://www.freecharge.in");
	}
	
	@Test
	public void method1()
	{				
		Loginpage lp=new Loginpage();
		lp.verifyLogin();
				
	}
	@AfterMethod
	public void tearDown()
	{
		UtilityClass.closeApplication();
	}

}
