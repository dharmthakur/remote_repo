package baseclasspackage;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.*;


public class BasePage {
	
	public Logger log=Logger.getLogger(BasePage.class.getName());
	private static final boolean alwaysRun = false;
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
		
	public void initialise(String browser,String url){
		initExtentreport();
		getWebdriver(browser);
		
		log.info("in initialise method");
		launchApplication(url);
		//logger.log(LogStatus.INFO,"Application launched");
	}
	
	public void getWebdriver(String browser){
		log.info("in webdriver method");
		if(browser.equalsIgnoreCase("CH")){
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver=new ChromeDriver();
	
		}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver","drivers/IEDriver.exe");
			driver=new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("FF")){
			driver=new FirefoxDriver();
		}
		else{
			driver=null;
		}
		
	}
	
	public String getScreenshots(String name) throws IOException{
		log.info("in screenshot method");
		
	TakesScreenshot screen=(TakesScreenshot)driver;
	File source=screen.getScreenshotAs(OutputType.FILE);
	String destfilepath="./screenshots/"+name+".png";
	File dest=new File(destfilepath);
	FileUtils.copyFile(source, dest);
		return destfilepath;
	}
	public void launchApplication(String url){
		log.info("in launchApplication method");
		driver.get(url);
		
	}
	
	public void initExtentreport(){
		log.info("in extentreport method");
		 report=new ExtentReports("./Report/report.html",false);
		 		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		log.info("inside aftermethod");
		if(result.getStatus()==result.FAILURE){
			logger.log(LogStatus.FAIL,logger.addScreenCapture(result.getName()));
			//String s=getScreenshots(result.getName());
			
		}else if(result.getStatus()==result.SKIP){
			logger.log(LogStatus.SKIP,result.getName()+"skipped"+result.getThrowable());
			
		}else if(result.getStatus()==result.SUCCESS){
			logger.log(LogStatus.PASS,result.getName()+"passed");
		}
		
		report.endTest(logger);
		report.flush();

	

	}
@AfterClass
	public void afterClass(){
	log.info("in afterclass");
	driver.quit();	
	}
	

}
