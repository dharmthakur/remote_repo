package com.safex.MDM.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFFDemo {

	public static void main(String[] args) {
		/*System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://internal-a7dc028c9079111ea86a00a1a1c1cf90-560679781.ap-south-1.elb.amazonaws.com/userwebui/");
		driver.close();*/
		System.setProperty("webdriver.edge.driver","drivers/MicrosoftWebDriver.exe");
		WebDriver driver1=new EdgeDriver();
		driver1.get("https://www.google.com");

	}

}
