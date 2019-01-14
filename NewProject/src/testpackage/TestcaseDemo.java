package testpackage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseclasspackage.BasePage;
import mypackage.HomePage;
import mypackage.LPage;

public class TestcaseDemo extends BasePage {
	Logger log=Logger.getLogger(TestcaseDemo.class.getName());
	@BeforeTest
	public void beforTest(){
		PropertyConfigurator.configure("./log4j/log4j.properties");
		log.info("in beforetest");
	}
	@BeforeClass
	@Parameters({"browser","url"})
	public void beforeMethod(String browser,String url){
		log.info("in before class");
		initialise(browser,url);
		
	}
	
	
	
	
	public void testCase1(){
		logger=report.startTest("testcase1");
		logger.log(LogStatus.INFO,"LPage validlogin method is invoked");
		new LPage(driver).validLogin();
		log.info("valid login verified");
		new HomePage(driver).signOut();
		log.info("signing out the application");
		//logger.log(LogStatus.INFO,"LPage validlogin method is invoked");
	}
		
	@Test
	public void testCase2(){
		logger=report.startTest("testcase2");
		logger.log(LogStatus.INFO,"LPage validlogin method is invoked");
		new LPage(driver).validLogin();
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("xyz"));
				
		//logger.log(LogStatus.INFO,"LPage validlogin method is invoked");
	}	
}
