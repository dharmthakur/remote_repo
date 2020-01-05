package com.safex.MDM.automation;

import org.testng.annotations.Test;

public class JenkinsParameterisedDemo {
	
	@Test
	public void fetchParameterfromJenkins() {
	
	System.out.println("hello ");
	String s=System.getProperty("testSuiteName");
	String s1=System.getProperty("Scriptdriversheet");
	String s2=System.getProperty("testdatasheet");
	System.out.println("suite is:"+s+" scriptdriversheet:"+s1+" testdatasheet:"+s2);
	//System.out.println("suite is:"+s);
	
	}

}
