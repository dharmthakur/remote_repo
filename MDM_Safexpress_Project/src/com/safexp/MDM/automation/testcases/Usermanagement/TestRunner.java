package com.safexp.MDM.automation.testcases.Usermanagement;

import org.testng.TestNG;

import com.safexp.MDM.automation.managerClasses.TestListener;


public class TestRunner {
	static TestNG testNG;
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
			TestListener ext=new TestListener();
		
			testNG=new TestNG();
		    testNG.setTestClasses(new Class[]{UsercreationTest.class});
		    testNG.addListener(ext);
		    testNG.run();
	   }

}
