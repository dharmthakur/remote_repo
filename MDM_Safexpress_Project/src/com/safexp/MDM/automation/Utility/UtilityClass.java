package com.safexp.MDM.automation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import com.safexp.MDM.automation.managerClasses.ReadExcelData;

public class UtilityClass {
	
    public static WebDriver driver=null;
	public static Properties OR=null;
	public static Properties conf=null;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	static Logger log=Logger.getLogger(UtilityClass.class.getName());
	public static void Init()
	{
		initOR();
		intitExtentReport();
		initLogReport();		
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
		try 
		{
		FileInputStream file_or=new FileInputStream("OR\\OR.properties");
		FileInputStream file_config=new FileInputStream("Config\\config.properties");

		OR=new Properties();
		conf=new Properties();
		OR.load(file_or);
		conf.load(file_config);
		}catch (IOException e)
		{
		 logger.fail("Object repository initialisation failed");
	    }
	}
	
	public static void webDriverInit(String dr)
	{
		if(dr.equalsIgnoreCase("CH"))
		{
			try 
			{
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	    	driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		    driver.manage().window().maximize();
	        }catch(Exception e)
	        {
		    logger.fail("webdriver initialisation failed");
	        }
		 }
		else if(dr.equalsIgnoreCase("IE"))
		 {
			try
			{
			System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		    }catch(Exception e)
		    {
			logger.fail("webdriver initialisation failed");
		    }
		}
		else if(dr.equalsIgnoreCase("FF")) 
		{
			try
			{
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		    }catch(Exception e)
		    {
			logger.fail("webdriver initialisation failed");
		    }
			
		}
		
	}
	
	public static void launchApplication(String url)
	{   webDriverInit("CH");
		//String url=conf.getProperty("AppUrl");
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
	public static String getTitleOfPage()
	{
		return(driver.getTitle());
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
	public static String getScreenshot()
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/Report/Screenshots/"+System.currentTimeMillis()+".png";
		
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
	}
////	
	public static void intitExtentReport() 
	{
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Report/extentreport.html");
		extent = new ExtentReports();
	    extent.attachReporter(reporter);
	
	}
	public static void closeAllWindow() {
		driver.quit();
	}
}