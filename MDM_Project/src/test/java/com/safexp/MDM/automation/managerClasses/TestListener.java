package com.safexp.MDM.automation.managerClasses;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.safexp.MDM.automation.Utility.UtilityClass;

public class TestListener implements ITestListener{

	String dot=".";
	public void onFinish(ITestContext arg0) {
		System.out.println("in onFinish method");
		
		
	}

	public void onStart(ITestContext arg0) {
		System.out.println("in onStart method");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("in onTestFailedButWithinSuccessPercentage");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("in onTestFailure");
		String path=dot+UtilityClass.getScreenshot(result);
		
		try {
			UtilityClass.logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		UtilityClass.extent.flush();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		//UtilityClass.logger.fail("testcase failed:"+result.getName());
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("in onTestSkipped");
		
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("in onTestStart method");
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("in onTestSuccess method");
		//UtilityClass.driver.close();

	}

}
