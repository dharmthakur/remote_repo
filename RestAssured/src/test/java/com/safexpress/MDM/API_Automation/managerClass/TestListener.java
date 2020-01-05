package com.safexpress.MDM.API_Automation.managerClass;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.safexpress.MDM.API_Automation.APIUtility.UtilityClassForAPI;

public class TestListener implements ITestListener {

	public void onFinish(ITestContext arg0)
	{
		System.out.println("in onFinish method");
		
		
	}

	public void onStart(ITestContext arg0)
	{
		System.out.println("in onStart method");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
	{
		System.out.println("in onTestFailedButWithinSuccessPercentage");
		
	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println("in onTestFailure");
		
	}

	public void onTestSkipped(ITestResult arg0)
	{
		System.out.println("in onTestSkipped");
		
	}

	public void onTestStart(ITestResult arg0) 
	{
		System.out.println("in onTestStart method");
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("in onTestSuccess method");
		//UtilityClass.driver.close();

	}

}
