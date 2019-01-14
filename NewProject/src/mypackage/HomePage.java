package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void signOut(){
		WebElement we=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement we1=driver.findElement(By.xpath("//a[contains(text(),'Sign')]"));
		Actions ac=new Actions(driver);
		ac.moveToElement(we).click(we1).build().perform();
	}
}
