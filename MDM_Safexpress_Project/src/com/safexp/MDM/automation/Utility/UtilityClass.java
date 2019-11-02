package com.safexp.MDM.automation.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.safexp.MDM.automation.managerClasses.ReadExcelData;

public class UtilityClass {
	
    public static WebDriver driver=null;
	public static Properties OR=null;
	public static Properties conf=null;
	
	public static ExtentReports report=null;

	static Logger log=Logger.getLogger(UtilityClass.class.getName());
	public static void Init()
	{
		initOR();
		intitExtentReport();
		initLogReport();		//webDriverInit();
	}
	
	public static void initLogReport()
	{
		PropertyConfigurator.configure("Log4j/log4j.properties");
		log.info("in beforetest");
	}
	public static void Initeration()
	{
		ReadExcelData.DataMap=ReadExcelData.DataIt.next();
	
	}
	
	public static void initOR() 
	{
		try {
		FileInputStream file_or=new FileInputStream("OR\\OR.properties");
		FileInputStream file_config=new FileInputStream("Config\\config.properties");

		OR=new Properties();
		conf=new Properties();
		OR.load(file_or);
		conf.load(file_config);
		}catch (IOException e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	
	public static void webDriverInit()
	{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void launchApplication()
	{   webDriverInit();
		String url=conf.getProperty("ApplUrl");
		driver.get(url);
	}
	public static void closeApplication()
	{
		driver.close();
	}
	
	public static void fn_Input(String s1,String s)
	{
		WebElement we=getWebElement(s1);
		we.sendKeys(s);
		
	}
	
	public static void fn_Click(String s)
	{
		WebElement we=getWebElement(s);
		we.click();
	}
	
	public static WebElement getWebElement(String object)
	{
		String xpath=OR.getProperty(object);
		WebElement we=driver.findElement(By.xpath(xpath));
		return we;
		
	}
	
	public static void intitExtentReport() {
		report=new ExtentReports("Report/report.html",true);
		
	}
}