package com.safexp.MDM.automation.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.safexp.MDM.automation.managerClasses.ReadExcelData;

public class BrowserLaunchDemo {

	public static void main(String[] args) {
		/*System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.freecharge.in");
		
		WebElement login_btn=driver.findElement(By.xpath("//a[text()='Login/Register']"));
		login_btn.click();
		WebElement usernm=driver.findElement(By.xpath("//input[@name='checkUsername']"));
		usernm.sendKeys("8448828089");
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("dharm1180");
		
		driver.close();*/
		
		//ReadExcelData readex=new ReadExcelData();
		//readex.readDataFromExcel("TestData\\testdata.xls");
		try {
			FileInputStream file=new FileInputStream("OR\\OR.properties");
			Properties OR=new Properties();
			OR.load(file);
			String xpath=OR.getProperty("Loginpage_login_btn");
			System.out.println(xpath);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
