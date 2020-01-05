package com.safexpress.MDM.API_Automation.APIUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.safexpress.MDM.API_Automation.managerClass.ReadExcelData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UtilityClassForAPI {
	
	public static ExtentReports extent;
	public static ExtentTest logger;

	
	public static RequestSpecification httpRequestObject=null;
	public static void Initialise_RequestObject(String uri)
	{
		RestAssured.baseURI=uri;

		//RestAssured.baseURI="http://internal-a667ae5a906cd11ea86a00a1a1c1cf90-41609411.ap-south-1.elb.amazonaws.com";

		httpRequestObject=RestAssured.given();
	}
	 
public static void readExcel()
{
	new ReadExcelData().readExcelData();
}
public static void initLogReport()
{System.out.println("log initialising");
	PropertyConfigurator.configure("Log4j/log4j.properties");
	//log.info("in beforetest");
}

public static void intitExtentReport() 
{System.out.println("extent report initialising");
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Report/extentreport.html");
	extent = new ExtentReports();
    extent.attachReporter(reporter);

}



	
	public static void writeExcel() 
	{
		
	}
	public static Boolean isExist(String endpointwithsomeuniqueid)
	{   Boolean exist=false;
		Response response=httpRequestObject.request(Method.GET,endpointwithsomeuniqueid);
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		int statusCode=response.getStatusCode();
		System.out.println("status code is:"+statusCode);
		try {
		Assert.assertEquals(statusCode, 200);
		String StatusLine=response.getStatusLine();
		System.out.println("Status line is:"+StatusLine);
		Assert.assertEquals(StatusLine,"HTTP/1.1 200 OK");
		exist=true;
		return exist;
		}catch(Exception e) {
			e.printStackTrace();
			return exist;
		}
		

	}
	

}
