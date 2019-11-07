package com.safexp.MDM.automation.managerClasses;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.safexp.MDM.automation.Utility.UtilityClass;

public class TestListener implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("in onFinish method");
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("in onStart method");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("in onTestFailedButWithinSuccessPercentage");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("in onTestFailure");
		String path=UtilityClass.getScreenshot();
		try {
			UtilityClass.logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("in onTestSkipped");
		
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("in onTestStart method");
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("in onTestSuccess method");

	}

}
