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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.safexp.MDM.automation.managerClasses.ReadExcelData;

public class UtilityClass {
	
    public static WebDriver driver=null;
	public static Properties OR=null;
	public static Properties conf=null;

	
	public static void Init()
	{
		initOR();
		webDriverInit();
		
		
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
	{
		String url=conf.getProperty("ApplUrl");
		driver.get(url);
	}
	public static void closeApplication()
	{
		driver.close();
	}
	
	public static void fn_Input(String s)
	{
		WebElement we=getWebElement(s);
		
	}
	
	public static void fn_Click()
	{
		
	}
	
	public static WebElement getWebElement(String object)
	{
		String xpath=OR.getProperty(object);
		WebElement we=driver.findElement(By.xpath(xpath));
		return we;
		
	}
}
