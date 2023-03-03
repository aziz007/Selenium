package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class jenkinsTest {
	
	
		//public static WebDriver driver;
	@Test (description = "enter credentials and hit enter button",priority =1)
		
		public void login() {
		Configuration.logger = Configuration.extent.startTest("Login – Positive test case");
		Configuration.logger.log(LogStatus.INFO, "Entering correct Username");
		Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
		Configuration.logger.log(LogStatus.INFO, "Entering correct Password");
		Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
		
		try {
			Configuration.logger.log(LogStatus.INFO, "Click submit button");
			Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(20000);
			
		} catch (Exception e) {
			// TODO: handle exception
			Configuration.logger.log(LogStatus.FAIL,e);
		
	}

	}
	@Test (description = "mouse over function",priority =2)
	public void mouseover() throws InterruptedException {
		Configuration.logger = Configuration.extent.startTest("Configuration => Cycle Creation");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
		WebElement conf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
		//conf.click();
		
		
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(conf).perform();
		
		Configuration.logger.log(LogStatus.INFO, "Click cycle from the drop-down menu");
		WebElement cycle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-menu-id='83']")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
		ac.moveToElement(cycle).click().perform();


	}
}
