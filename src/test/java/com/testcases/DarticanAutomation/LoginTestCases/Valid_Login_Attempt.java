package com.testcases.DarticanAutomation.LoginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.testcases.DarticanAutomation.Configuration;

public class Valid_Login_Attempt {

public static WebDriver driver;
	

	
	@Test (description = "Enter credentials and hit enter button",priority =1)
		
		public void login() 
			{
		
				String titleexpected = "Compensation Planning";
			
				try 
				{
						WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
						Configuration.logger = Configuration.extent.startTest("Valid Login Attempt");
						
						String titleread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/p[1]"))).getText();
						Assert.assertEquals(titleread, titleexpected);
						
						if(titleread.equals(titleexpected))
						{
							Configuration.logger.log(LogStatus.INFO, titleexpected);
						}
				}
				catch(Exception e)
				{
						Configuration.logger.log(LogStatus.FAIL,e);
				}
		
				
				try 
				{
						Configuration.logger.log(LogStatus.INFO, "Entering correct username");
						Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
						Configuration.logger.log(LogStatus.INFO, "Entering correct password");
						Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
						
						Configuration.logger.log(LogStatus.INFO, "Hit Login button");
						Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
						Thread.sleep(10000);							
				} 
				catch (Exception e) 
				{
						// TODO: handle the exception
						Configuration.logger.log(LogStatus.FAIL,e);
					
				}
	}
}
