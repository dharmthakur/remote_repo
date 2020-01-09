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
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
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
	
	public static String expectedUserid;
	
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
		FileInputStream file_or=new FileInputStream("OR/OR.properties");
		FileInputStream file_config=new FileInputStream("Config/config.properties");

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
			//System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			  ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
			driver=new ChromeDriver(chromeOptions);
	    	//driver=new ChromeDriver();
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
			//System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver","/usr/bin/IEDriverServer");
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
				
			System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		    }catch(Exception e)
		    {
			logger.fail("webdriver initialisation failed");
		    }
			
		}
		
	}
	
	public static void launchApplication(String url)
	{   webDriverInit("FF");
		//String url=conf.getProperty("AppUrl");
		driver.get("https://www.google.com");
		
	}
	public static void launchUrl(String browser,String url)
	{   webDriverInit(browser);
		//String url=conf.getProperty("AppUrl");
		driver.get(url);
		
	}
	public static void closeApplication()
	{
		driver.close();
	}
	
	public static void clickOnElementByIndexInList(String listxpath,int index)
	{    String xpath=OR.getProperty(listxpath);
		 List<WebElement> wb=UtilityClass.driver.findElements(By.xpath(xpath));
		 wb.get(index-1).click();
	}
	
	
	public static void fn_Input(String s1,String s)
	{
		System.out.println(s);
		WebElement we=getWebElement(s1);
		//JavascriptExecutor je=(JavascriptExecutor)driver;
		//je.executeScript("arguments[0].value='"+s+"'",we);
		we.sendKeys(s);
		
	}
	
	public static void fn_metaselect(String metaselectxpath,String metaoptionxpath)
	{
		WebElement we=getWebElement(metaselectxpath);
		we.click();
		WebElement we2=getWebElement(metaoptionxpath);
		we2.click();		
	}
	
	public static String getdataofWebTable(String xpath) 
	{
		WebElement we=getWebElement(xpath);
		return(we.getText());
		
	}
	public static void validateString(String actual)
	{
		System.out.println("in validate fn");
		System.out.println(actual);
		System.out.println(expectedUserid);
		if(actual.equalsIgnoreCase(expectedUserid))
		{
			log.info("string matched and as expected");
		}
		else
		{
			log.info("string not found");
			
		}
	}
	
	public static void fn_SelectByVisibleText(String xpath,String text) 
	{
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
	{WebElement we=getWebElement(s);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",we);
		
		System.out.println("button clicked");
	}catch(Exception e) {
		//WebElement we=getWebElement(s);
		we.click();
		System.out.println("button clicked");
	}
	}
	
	public static WebElement getWebElement(String object)
	{
		String xpath=OR.getProperty(object);
		System.out.println(xpath);
		WebElement we=driver.findElement(By.xpath(xpath));
		return we;
		
	}
	
	public static String genRandomNumber()
	{
		int nk;
    	Random rn=new Random();
    	nk=rn.nextInt();
    	if(nk<0)
    	{
    		nk=nk*(-1);
    	}
        String s=Integer.toString(nk);
        return(s.substring(0,3));
 
	}
	
	public static void pressDownArrowKey(String Object)
	{
		WebElement wb=getWebElement(Object);
		Actions a=new Actions(driver);
		a.moveToElement(wb).sendKeys(Keys.ARROW_DOWN);
				
	}
	public static void pressEnterKey(String Object)
	{
		WebElement wb=getWebElement(Object);
		//Actions a=new Actions(driver);
		wb.sendKeys(Keys.RETURN);
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
		
	}
	public static String getScreenshot(ITestResult result)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		//String path=System.getProperty("user.dir")+"/Report/"+System.currentTimeMillis()+".png";
		String path="./Report/Screenshots/"+System.currentTimeMillis()+".png";
		System.out.println(path);
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		}catch (IOException e) {
		
			System.out.println("Capture Failed "+e.getMessage());
		}
			
		return path;
	}
////	
	public static void deleteFolder(File folder) {
		log.info("clearing Report directory");
	    File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    //folder.delete();
	}
	
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