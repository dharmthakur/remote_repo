package mypackage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class LPage {
    Logger log=Logger.getLogger(LPage.class.getName());
	WebDriver driver;
	
	public LPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void validLogin(){
		driver.findElement(By.name("user_name")).sendKeys("admin");
		log.info("username entered");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		log.info("password entered");
		driver.findElement(By.id("submitButton")).click();
		log.info("clicked on submit button");
	}
		
		
	

}
