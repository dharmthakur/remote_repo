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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
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
	{  // log.info("initialising OR");
		initOR();
		//log.info("initialising extentreport");
		intitExtentReport();
		//log.info("initialising log");
		initLogReport();		
	}
	
	public static void initLogReport()
	{
		PropertyConfigurator.configure("Log4j/log4j.properties");
		//log.info("log  initialised");
	}
	public static void Initeration()
	{
		//log.info("fetching next data from excel");
		ReadExcelData.DataMap=ReadExcelData.DataIt.next();
		//log.info("fetched next data from excel");
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
		// log.info("Object repository initialisation failed");
	    }
		
		//log.info("OR initialised");
		
	}
	
	public static void webDriverInit(String dr)
	{
		//log.info("initialising webdriver");
		if(dr.equalsIgnoreCase("CH"))
		{
			//log.info("chrome webdriver is being initialised");
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
			//log.info("IE webdriver is being initialised");
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
			//log.info("firefox webdriver is being initialised");
			try
			{
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		    }catch(Exception e)
		    {
			logger.fail("webdriver initialisation failed");
		    }
			
		}
		//log.info("webdriver initialised successfully");
	}
	
	public static void launchApplication(String url)
	{   webDriverInit("CH");
		//String url=conf.getProperty("AppUrl");
	   // log.info("launching application url");
		driver.get(url);
		//log.info("application launched");
	}
	public static void closeApplication()
	{
		//log.info("closing the application window");
		driver.close();
	}
	
	public static void clickOnElementByIndexInList(String listxpath,int index)
	{    
		String xpath=OR.getProperty(listxpath);
		 List<WebElement> wb=UtilityClass.driver.findElements(By.xpath(xpath));
		 wb.get(index-1).click();
		// log.info("specified element in the list is clicked");
		 
	}
	
	
	public static void fn_Input(String s1,String s)
	{
		System.out.println(s);
		WebElement we=getWebElement(s1);
		//JavascriptExecutor je=(JavascriptExecutor)driver;
		//je.executeScript("arguments[0].value='"+s+"'",we);
		we.sendKeys(s);
		//log.info("input to textfield is done");
		
	}
	
	public static void fn_SelectByVisibleText(String xpath,String text) {
		WebElement element=getWebElement(xpath);
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
 public static void fn_SelectByIndex(String xpath,String index) {
		
	}
 public static void fn_SelectByValue(String xpath,String value) {
		
	}
 
	public static String getTitleOfPage()
	{
		return(driver.getTitle());
	}
	public static void fn_Click(String s)
	{
		WebElement we=getWebElement(s);
		we.click();
		//log.info("specified button is clicked ");
	}
	
	public static WebElement getWebElement(String object)
	{
		//log.info("locating webelement");
		String xpath=OR.getProperty(object);
		System.out.println(xpath);
		WebElement we=driver.findElement(By.xpath(xpath));
		//log.info("webelement found ");
		return we;
		
	}
	public static String getTextOnElement(String Object)
	{
		WebElement wb=getWebElement(Object);
		String text=wb.getText();
		return text;
	}
	public static void scrollToElementIntoView(String object)
	{
		WebElement element=getWebElement(object);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		//log.info("element scrolled into view");
		
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
			//log.info("screenshot capturing failed");
		}
		//log.info("screenshot taken");
		return path;
	}
////	
	public static void intitExtentReport() 
	{
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Report/extentreport.html");
		extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    //log.info("extentreport initialised");
	
	}
	public static void closeAllWindow() {
		//log.info("closing all open windows");
		driver.quit();
	}
}