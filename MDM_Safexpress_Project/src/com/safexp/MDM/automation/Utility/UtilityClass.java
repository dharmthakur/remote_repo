package com.safexp.MDM.automation.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilityClass {
	
public static WebDriver driver=null;
	public static Properties OR=null;
	
	public UtilityClass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static void Init()
	{
		initOR();
		webDriverInit();
		
		
	}
	
	public static void initOR() 
	{try {
		FileInputStream file=new FileInputStream("OR\\OR.properties");
		OR=new Properties();
		OR.load(file);
		
	} catch (IOException e) {
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
	
	public static void launchApplication(String appurl)
	{
		driver.get(appurl);
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
