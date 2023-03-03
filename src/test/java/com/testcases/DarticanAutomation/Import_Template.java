package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Import_Template {
	
	
	

	
	public static WebDriver driver;
	@Test (description = "enter credentials and hit enter button",priority =1)
		
		public void login() {
		Configuration.logger = Configuration.extent.startTest("Valid login");
		Configuration.logger.log(LogStatus.INFO, "Entering username");
		Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
		Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
		
		try {
			Configuration.logger.log(LogStatus.INFO, "Click submit button");
			Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(100000);			
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println("button not clicked");
		
	}

	}
	
	
	
	@Test(priority = 2)
	public void SelectTemplate() throws InterruptedException {
									
		
		//Configuration.driver.findElement(By.xpath("//*[@id=\"selected-planning-cycle\"]/ul/li/div/a[1]")).click();
		Configuration.logger = Configuration.extent.startTest("Select Template");
	Configuration.driver.findElement(By.xpath("//*[@id='grid-template']/tbody/tr[8]/td")).click();
	Thread.sleep(30000);
		System.out.println("clicked row");
		
		
		try {
			Configuration.logger.log(LogStatus.INFO, "Select title for merit");
			String valuetitlemerit = Configuration.driver.findElement(By.xpath("//*[@id='grid-column']/tbody/tr[15]/td[2]")).getText();
			System.out.println(valuetitlemerit);
			Configuration.logger.log(LogStatus.INFO, "Select veiwabletype for merit");
			String meritviewable = Configuration.driver.findElement(By.xpath("//*[@id='grid-column']/tbody/tr[15]/td[7]")).getText();
			System.out.println(meritviewable);
			Thread.sleep(10000);							
			Configuration.logger.log(LogStatus.INFO, "Open import templates");
			Configuration.driver.findElement(By.xpath("//*[@id='select2-5088-container']")).click();
			WebElement enterkey = Configuration.driver.findElement(By.xpath("//*[@id=\"body\"]/span/span/span[1]/input"));
			enterkey.sendKeys("Import",Keys.ENTER);
			Thread.sleep(25000);
			Configuration.logger.log(LogStatus.INFO, "Click employee information");
		Configuration.driver.findElement(By.xpath("//*[@id='grid-template']/tbody/tr[12]/td")).click();
		Thread.sleep(30000);
		
		Configuration.logger.log(LogStatus.INFO, "Search and verify title for merit");
		String valuetitleimport = Configuration.driver.findElement(By.xpath("//*[@id='grid-column']/tbody/tr[18]/td[2]")).getText();
		System.out.println(valuetitleimport);
		
		Configuration.logger.log(LogStatus.INFO, "Search and verify viewabletype for merit");
		String importviewable = Configuration.driver.findElement(By.xpath("//*[@id='grid-column']/tbody/tr[18]/td[7]")).getText();
		System.out.println(importviewable);
		
		if(meritviewable.equals(importviewable))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
	}
		
		catch(Exception e)
		{
			System.out.println("Wrong job Business Rule");
		}
	}
}
