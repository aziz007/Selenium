package com.testcases.DarticanAutomation.LoginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.testcases.DarticanAutomation.Configuration;

public class Forget_Password {

	
public static WebDriver driver;
	

	
	@Test (description = "Enter credentials and hit enter button",priority =1)
		
		public void login() 
			{
		
				String titleexpected = "Compensation Planning";
			
				try 
				{
						WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
						Configuration.logger = Configuration.extent.startTest("Wrong Password");
						
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
						Configuration.logger.log(LogStatus.INFO, "Entering Username");
						Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
						Configuration.logger.log(LogStatus.INFO, "Enter wrong password");
						Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mger");
						
						Configuration.logger.log(LogStatus.INFO, "Click Login button,'Show Error'");
						Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
						Thread.sleep(10000);
				} 
				catch (Exception e)
				{
						// TODO: handle the exception
						Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				
				String errorexpected = "Invalid login attempt.";
				
				try 
				{
						WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
						
						String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/form/div[1]/ul/li"))).getText();
						Assert.assertEquals(errorread, errorexpected);
						
						if(errorread.equals(errorexpected))
						{
							Configuration.logger.log(LogStatus.INFO, errorexpected);
						}
				}
				catch(Exception e)
				{
						Configuration.logger.log(LogStatus.FAIL,e);
				}
				
	}
	
	@Test (priority =2)
	
	public void ForgetPassword() 
	{
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Forget Password");
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click forget your password link");
			WebElement forget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/form/div[4]/div[2]/a")));
			forget.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
	}
}
